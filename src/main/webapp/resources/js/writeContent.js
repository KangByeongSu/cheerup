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

		var textareaData = hashtagSplit[0];

		for (var i = 1; i < hashtagSplit.length; i++) {
			var hashtagTemp = hashtagSplit[i].split(" ");
			var hashtag = hashtagTemp[0];

			textareaData += "<span style='color:blue'>" + hashtag + "</span>";
			for (var j = 1; j < hashtagTemp.length; j++) {
				textareaData += hashtagTemp[j];
			}
		}
		e.target.innerHTML = textareaData;
	});

}(document, window, 0));

function getHashToString() {
	var inputValue = document.querySelector("#styled").value;
	var hashtagSplit = inputValue.split("#");

	var textareaData = "";

	for (var i = 1; i < hashtagSplit.length; i++) {
		var hashtagTemp = hashtagSplit[i].split(" ");
		var hashtag = hashtagTemp[0];

		textareaData += hashtag;
		if (i < hashtagSplit.length - 1)
			textareaData += "-||-";

	}
	return textareaData;
}

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
