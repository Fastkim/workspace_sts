<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<link href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css' rel='stylesheet'>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js'></script>
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script>
function isVal(field) {
    let isGood = false // boolean 초기화 기본값 : false , String : emptyString , Number : 0 , flag variable
    let errMsg

    if(!field.length) errMsg = '노동자를 선택하세요.'
    else {
        if(!field.val()) errMsg = field.attr('$placeholder') + '입력하세요.'
        else isGood = true
    }

    if(!isGood) {
        $('#modalMsg').text(errMsg).css('color','red')
        $('#modalBtn').hide()
        $('#modal').modal('show')
    }

    return isGood
}

function listLaborers() {
	$('input').not(':radio').val('') // radio가 아닌걸 찾아낸후 emptyString 처리해서 처리해준다.
    $('#laborers').empty()
    
	if('#laborers' != null) {
		$.ajax({
			url: 'laborer/list',
			success: laborers => {
				const laborerArr = []
				laborers.forEach(laborer => {
					laborerArr.unshift(
						`<tr>
		                    <td><input type='radio' value='\${laborer.laborerId}' id='laborerId' name='laborerId'/></td>
		                    <td>\${laborer.laborerId}</td>
		                    <td>\${laborer.laborerName}</td>
		                    <td>\${laborer.hireDate}</td>
		                </tr>`
					)
				})
				
				$('#laborers').empty()
				$('#laborers').append(laborerArr.join(''))
			}
		})
	} else $('#laborers').append('<tr><td colspan="4" class="text-center">노동자가 없습니다.</td></tr>')
}

function init() { // 페이지가 시작하자마자 하는 작업을 의미
    listLaborers()
    
    $('#addLaborerBtn').click(() => {
    	$.ajax({
    		url: 'laborer/add',
    		method: 'post',
    		contentType: 'application/json',
    		data: JSON.stringify({
				laborerName: $('#laborerName').val(),
				hireDate: $('#hireDate').val()
    		}),
    		success: listLaborers
    	})
    })

    // 노동자 수정
    $('#fixLaborerBtn').click(() => {
    	$.ajax({
    		url: 'laborer/fix',
    		method: 'put',
    		contentType: 'application/json',
    		data: JSON.stringify({
    			laborerId: $('#laborerId:checked').val(),
    			laborerName: $('#laborerName').val(),
    			hireDate: $('#hireDate').val()
    		}),
    		success: listLaborers
    	})
    })

    // 노동자 삭제
    $('#delLaborerBtn').click(() => {
         if(isVal($('#laborerId:checked'))) {
             $('#modalMsg').text('노동자를 삭제하시겠습니까?')
             $('#modalBtn').show()
             $('#modal').modal('show')
         }
     })
    
    $('#delLaborerOkBtn').click(() => {
    	$.ajax({
    		url: 'laborer/del/' + $('#laborerId:checked').val(),
    		method: 'delete',
    		success: function finish() {
    			$('#modal').modal('hide')
    			listLaborers()
    		}
    	})
   	})
}

$(init)  // call
</script>
<style>
#hireDate::before {
    content: attr(placeholder);
    width: 100%;
}

#hireDate:focus::before, #hireDate:valid::before {
    display: none;
}
</style>




<div class='container'>
            <div class='row mb-5'>
                <div class='col'>
                    <header class='p-2 bg-light shadow'>
                        <h1 class='text-center'><b>HR</b></h1>
                    </header>
                </div>
            </div>
            <div class='row'>
                <div class='col'>
                    <form>
                        <div class='row mb-3'>
                            <div class='col-2'>
                                <input type='text' class='form-control' placeholder='노동자명' id='laborerName'/>
                            </div>
                            <div class='col-5'>
                                <div class='row'>
                                    <div class='col-4 d-none d-md-inline text-end align-bottom pt-2'>
                                        <label for='hireDate'>입사일: </label>
                                    </div>
                                    <div class='col'>
                                        <input type='date' class='form-control' id='hireDate'
                                            placeholder='입사일' required/>
                                    </div>
                                </div>
                            </div>
                            <div class='col'>
                                <div class='d-flex gap-2 justify-content-end'>
                                    <button type='button' class='btn btn-primary col-4' id='addLaborerBtn'>
                                        <i class='bi bi-plus-circle'></i>
                                        <span class='label d-none d-md-inline'>&nbsp;추가</span>
                                    </button>
                                    <button type='button' class='btn btn-success col-4' id='fixLaborerBtn'>
                                        <i class='bi bi-check-circle'></i>
                                        <span class='label d-none d-md-inline'>&nbsp;수정</span>
                                    </button>
                                    <button type='button' class='btn btn-danger col-4' id='delLaborerBtn'>
                                        <!-- data-bs-toggle='modal' data-bs-target='#delLaborerModal'> -->
                                <i class='bi bi-x-circle'></i>
                                <span class='label d-none d-md-inline'>&nbsp;삭제</span>
                            </button>
                        </div>
                    </div>
                </div>
                <div class='row'>
                    <div class='col'>
                        <table class='table'>
                            <thead class='table-warning'>
                                <tr><th></th><th>ID</th><th>이름</th><th>입사일</th></tr>
                            </thead>
                            <tbody id='laborers'>
                                <tr><td colspan='4' class='text-center'>노동자가 없습니다.</td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class='modal fade' id='modal'>
    <div class='modal-dialog'>
        <div class='modal-content'>
            <div class='modal-header'>
                <button type='button' class='btn-close' data-bs-dismiss='modal'></button>
            </div>
            <div class='modal-body'>
                <!--<p>노동자를 삭제하시겠습니까?</p>-->
                <p id='modalMsg'></p>
            </div>
            <div class='modal-footer' id='modalBtn'>
                <button type='button' class='btn btn-primary' id='delLaborerOkBtn'>예</button>
                <button type='button' class='btn btn-secondary' 
                    data-bs-dismiss='modal'>아니오</button>
            </div>
        </div>
    </div>
</div>