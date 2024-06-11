<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>

<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script>
	function listFruits() {
		$.ajax({
			url: "fruits.jsp",
			dataType: "json",
			success: fruits => {
				console.log("test", fruits)
				/*
				if(fruits.length) {
					const fruitArr = []
					$.each(fruits, (i, fruit) => {
						fruitArr.push(
								`<li>
									\${fruit.fruitName}  //template 리터럴에서 쓰는 변수, EL이 아니다.
									\${fruit.price}
								</li>`
						)
					})
					$('#fruits').append(fruitArr.join(''))
				} else $('#fruits').append('<li>과일이 없습니다.</li>') // io 작업은 데이터가 있는지 꼭 확인하라.
				*/
			}
		})
	}
	
	${listFruits}
</script>

<ul id='fruits'></ul>