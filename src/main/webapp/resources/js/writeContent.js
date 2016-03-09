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

	});
	document.getElementById("styled").addEventListener("input", function(e) {
		var inputValue = e.target.value;
		var hashtagSplit = inputValue.split("#");

		// innerHTML로 넣어준다.
		// 일단 value다 받는다. 여기서
		/*
		 * ㅇㅁㄴㄻㄴㄹ #ㄹㅇㅁㄹ #ㅁㄴㅇㄹㅇ ㅁㄴㅇㄻㄴㄹ ㄴㅇㅁㄻㄴㄹ #ㅁㅇㄻㅇㄹ ㅁㅇㄹㄴㅇㄹ #ㅁㄴㅇㄻㄹ #으로 자르면 0번이
		 * ㅇㅁㄴㄻㄴㄹ 이다 1번은 2번은 #ㅁㄴㅇㄻㅇ이다
		 * 
		 * 
		 * 1. 0번값 넣는다. 2. #으로 자른거 넣기전에 스페이스로 split split 한 0 번에 font넣어서 넣는다 3.
		 * split 한 나머지 1~length만큼 += 한다. 포문돌린다.
		 */
		var textareaData = hashtagSplit[0];
	//	alert("size + " + hashtagSplit.length);
		for (var i = 1; i < hashtagSplit.length; i++) {
			var hashtag = hashtagSplit[i].split("/\b\s+(?!$)/")[0];

			textareaData += "<span style='color:blue'>" + hashtag + "</span>";
	//		alert(hashtag.length);
			for (var j = 1; j < hashtag.length; j++) {
				textareaData += hashtag[j];
			}
		}
		alert(textareaData);
		e.target.innerHTML = textareaData;
	});

	document.getElementById("submitText").addEventListener('click',
			function(e) {

				var text = document.querySelector("#styled").value;

				var textForm = document.createElement("input");

				textForm.setAttribute("name", "text");
				textForm.setAttribute("type", "hidden");
				textForm.setAttribute("value", text);

				var imageForm = document.createElement("input");
				imageForm.setAttribute("name", "imageFile");
				imageForm.setAttribute("type", "file");
				imageForm.setAttribute("value", $("#file-2")[0].files[0]);

				document.textUploadForm.appendChild(textForm);
				document.textUploadForm.appendChild(imageForm);
				document.textUploadForm.submit();
			});

}(document, window, 0));

function setbg(color) {
	document.getElementById("styled").style.background = color
}

function setBorder() {
	document.getElementById("submitText").style.border = "1px solid black";
}

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {

			document.querySelector(".upload-content-image").style.display = "none";
			document.querySelector(".upload-content-text").style.display = "block";
			document.querySelector(".upload-footer").style.display = "block"; //
			$('#thumbnail').attr('src', e.target.result).width("100%");

		};
		reader.readAsDataURL(input.files[0]);

	}
}
/*
 * var imageUploadAjax = function() { var imgData = new FormData();
 * imgData.append("imageFile", $("#file-2")[0].files[0]);
 * 
 * $.ajax({ type : "post", url : "./uploadImageToServer", processData : false,
 * contentType : false, cache : false, data : imgData, success : function(data) {
 * 
 * //이미지를 받을필요없다 이미지의 이름을 받아야한다. // url만 받아오는게 개선점
 * document.querySelector(".upload-content-image").style.display = "none";
 * document.querySelector(".upload-content-text").style.display = "block";
 * document.querySelector(".upload-footer").style.display = "block"; //
 * document.getElementById("imageViewer").innerHTML=data; // block 풀고 image넣을
 * id가져와서 이미지 넣는다. }, error : function(request, status, error) { alert("code:" +
 * request.status + "\n" + "message:" + request.responseText + "\n" + "error:" +
 * error); } }); }
 */
