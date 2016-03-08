/**
 * Created By Byeongsu
 */

'use strict';


(function(document, window, index) {
	var input = document.querySelector('.inputfile');
	var label = input.nextElementSibling, labelVal = label.innerHTML;
	input.addEventListener('change', function(e) {
		var fileName = '';
		if (this.files && this.files.length > 1)
			fileName = (this.getAttribute('data-multiple-caption') || '')
					.replace('{count}', this.files.length);
		else
			fileName = e.target.value.split('\\').pop();

		if (fileName)
			label.querySelector('span').innerHTML = fileName;
		else
			label.innerHTML = labelVal;

		document.uploadForm.submit();
	});

	// Firefox bug fix
	input.addEventListener('focus', function() {
		input.classList.add('has-focus');
	});
	input.addEventListener('blur', function() {
		input.classList.remove('has-focus');
	});
	
	document.getElementById("submitText").addEventListener('mouseover',function(e){
		document.getElementById("submitText").style.border ="2px solid black";
	});
	document.getElementById("submitText").addEventListener('mouseout',function(e){
		document.getElementById("submitText").style.border ="0px solid black";
	});
	document.getElementById("submitText").addEventListener('click',function(e){
		
		var text=document.querySelector("#styled").value;
		
		 var inputForm = document.createElement("input");
		 inputForm.setAttribute("name","text");
		 inputForm.setAttribute("type","hidden");
		 inputForm.setAttribute("value",text);
		 document.textUploadForm.appendChild(inputForm);
		 document.textUploadForm.submit();
	});

}(document, window, 0));

var imageUploadAjax = function() {
	var imgData = new FormData();
	imgData.append("imageFile", $("#file-2")[0].files[0]);

	$.ajax({
				type : "post",
				url : "./uploadImageToServer",
				processData : false,
				contentType : false,
				cache : false,
				data : imgData,
				success : function(data) {
					
					//이미지를 받을필요없다 이미지의 이름을 받아야한다.
					
					alert("data" + data); // innerHTML수정, 적은량의 데이터를 받는게 중요 이미지
					// url만 받아오는게 개선점
					document.querySelector(".upload-content-image").style.display = "none";
					document.querySelector(".upload-content-text").style.display = "block";
					document.querySelector(".upload-footer").style.display = "block";
					// document.getElementById("imageViewer").innerHTML=data;
					// block 풀고 image넣을 id가져와서 이미지 넣는다.

				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:"
							+ request.responseText + "\n" + "error:" + error);
				}
			});

}
function setbg(color) {
	document.getElementById("styled").style.background = color
}

function setBorder() {
	document.getElementById("submitText").style.border = "1px solid black";
}