/**
 * 2016-03-10 Created By Byeongsu
 */

'use strict';
(function(document, window, index) {

	var removeInput = document.querySelectorAll("html")[0];
	var input = document.querySelector('.inputfile');
	var label = input.nextElementSibling, labelVal = label.innerHTML;
	
	
	/**
	 * remove original input Form
	 */
	removeInput.className = removeInput.className.replace(/(^|\s)no-js(\s|$)/,
			"$1js$2");

	/**
	 * @method : Hashtag recognization Event (still developing...)
	 * discuss in codereview time
	 */
	/*document
			.getElementById("styled")
			.addEventListener(
					"input",
					function(e) {
						var input_value = e.target.value;
						// 1. input을 받아온다.
						// 2. 받아온 input 전체를 div에 +=한다.
						// 3. input을 비운다.
						// 4. div의 value를 파싱한다.
						console.log("input_value : ", input_value);

						var hashtagSplit = input_value.split("#");
						var textareaData = hashtagSplit[0];

						for (var i = 1, max = hashtagSplit.length; i < max; i += 1) {
							var hashtagTemp = hashtagSplit[i].split(" ");
							var hashtag = hashtagTemp[0];
							textareaData += "<span style='color: red'>#"
									+ hashtag + "</span>";
							for (var j = 1, temp_max = hashtagTemp.length; j < temp_max; j += 1) {
								textareaData += hashtagTemp[j];
							}
						}
						// document.getElementById("adapted-hashtag").innerHTML
						// = textareaData;
					});*/

	/**
	 * @method : submit click event - submit clientside validation
	 */
	document
			.getElementById("submitText")
			.addEventListener(
					"click",
					function(e) {
						var hashes = getHashToString(), comment = document
								.getElementById("styled").value, file = document
								.getElementById("file-2").value;
						// validation

						if (hashes == "") {
							document.getElementById("hashing").value = "";

						} else {
							document.getElementById("hashing").value = hashes;
						}
						if (file.indexOf(".png") == -1
								&& file.indexOf(".jpg") == -1
								&& file.indexOf(".jpeg") == -1) {
							alert("Please Insert Image File ( ex - .png, .jpg, .jpeg)");
						} else {
							if (comment == null || comment == "") {
								alert("Please insert your comment!");
							} else {
								document.textUploadForm.submit();
							}
						}
					});

}(document, window, 0));

/**
 * @method extract hash tag method
 * @param none
 *            get value textarea in Dom.
 * @returns {String}
 */
function getHashToString() {
	var inputValue = document.querySelector("#styled").value;
	var hashtagSplit = inputValue.split("#");

	var textareaData = "";

	for (var i = 1, max = hashtagSplit.length; i < max; i += 1) {
		var hashtagTemp = hashtagSplit[i].split(" ");
		var hashtag = hashtagTemp[0];

		textareaData += hashtag;
		if (i < max - 1)
			textareaData += "-||-";

	}
	return textareaData;
}

/**
 * @method change the background color method
 * @param color
 */
function setbg(color) {
	document.getElementById("styled").style.background = color
}

/**
 * @method change the border method
 */
function setBorder() {
	document.getElementById("submitText").style.border = "1px solid black";
}

/**
 * @method read a selected image file and redraw img to Dom
 * @param {file
 *            object}
 */
function readURL(input) {
	var reader = new FileReader();
	if (input.files && input.files[0]) {
		reader.onload = function(e) {
			document.querySelector(".upload-content-image").style.display = "none";
			document.querySelector(".upload-content-text").style.display = "block";
			document.querySelector(".upload-footer").style.display = "block"; //
			$('#thumbnail').attr('src', e.target.result).width("100%");
		};
		reader.readAsDataURL(input.files[0]);
	}
}
