<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<script src='http://code.jquery.com/jquery-3.6.0.min.js'></script> <!-- jquery library-->
<script>
function init() {
	$('#getBtn').click(() => {
		$.ajax({
			url: 'get',
			method: 'get' ,
			data: { // 객체형태로 만듬
				userId: 1, // json은 key에 double quotation이 있어야한다.
				username: '최한석', // queryString에 parameter url은 header 
				birthday: '2024-04-12'
			},
			contentType: 'application/x-www-form-urlencoded' // binary형태는 urlencoded대신 encType으로 했었다.
		}).done(user => console.log(user)) // done(success) handler에서 user객체는 javascript 객체인걸 관리자도구(F12) console에서 확인할수 있었다.
	})
	
	$('#postBtn').click(() => {
		$.ajax({
			url: 'post',
			method: 'post',
			data: JSON.stringify({ //parameter로 준 object를 json으로 바꿔줌
				userId: 2,
				username: '한아름',
				birthday: '2024-05-23'
			}),
			contentType: 'application/json'
		}).done(user => console.log(user))
	})
	
		$('#putBtn').click(() => {
			$.ajax({
				url: 'put',
				method: 'put',
				data: JSON.stringify({
					userId: 3,
					username: '양승일',
					birthday: '2024-12-01'
			}),
			contentType: 'application/json'
		}).done(user => console.log(user))
	})
		
	$('#patchBtn').click(() => {
		$.ajax({
			url: 'patch',
			method: 'patch',
			data: JSON.stringify({
				userId: 4,
				username: '김가람',
				birthday: '2024-07-07'
			}),
			contentType: 'application/json'
		}).done(user => console.log(user))
	})
	
	$('#deleteBtn').click(() => {
		$.ajax({
			url: 'delete',
			method: 'delete',
			data: JSON.stringify({
				userId: 5,
				username: '박돈일',
				birthday: '2025-02-12'
			}),
			contentType: 'application/json'
		}).done(user => console.log(user))
	})
}

$(init) <!-- document raddit -->
</script>
<nav>
	<button type='button' id='getBtn'>GET</button>
	<button type='button' id='postBtn'>POST</button>
	<button type='button' id='putBtn'>PUT</button> <!-- button 객체는 id에 Btn을 붙이는 관례가있다. -->
	<button type='button' id='patchBtn'>PATCH</button>
	<button type='button' id='deleteBtn'>DEL</button>
	<!-- DOM: HTML이 만드는 객체 -->
</nav>