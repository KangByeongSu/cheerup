/**
 *  Created By Byeongsu
 */


'use strict';

;( function ( document, window, index )
{
	var inputs = document.querySelectorAll( '.inputfile' );
	Array.prototype.forEach.call( inputs, function( input )
	{
		alert("HI");
		var label	 = input.nextElementSibling,
			labelVal = label.innerHTML;
		alert("Label : " + label);
		input.addEventListener( 'change', function( e )
		{
			alert("change EVENT!");
			var fileName = '';
			if( this.files && this.files.length > 1 )
				fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
			else
				fileName = e.target.value.split( '\\' ).pop();

			
			alert("fimeName : " + fileName);
			if( fileName )
				label.querySelector( 'span' ).innerHTML = fileName;
			else
				label.innerHTML = labelVal;
			
			
			
			document.uploadForm.submit();	
		});

		// Firefox bug fix
		input.addEventListener( 'focus', function(){ input.classList.add( 'has-focus' ); });
		input.addEventListener( 'blur', function(){ input.classList.remove( 'has-focus' ); });
	});
}( document, window, 0 ));





var imageUploadAjax = function() {

	alert("form call");
	var imgData = new FormData(); 
	imgData.append("imageFile", $("#file-2")[0].files[0]);
	
	
	alert("image Data - "+imgData);
	$.ajax({
		type : "post",
		url : "./uploadImageToServer", 
		processData: false,
        contentType: false,
        cache : false,
		data : imgData,
		success : function(data) {
			alert("SUCCESS");
			alert("data" + data); //innerHTML수정, 적은량의 데이터를 받는게 중요  이미지 url만 받아오는게 개선점
			document.querySelector(".upload-content-image").style.display="none";
			document.querySelector(".upload-content-text").style.display="block";
			document.querySelector(".upload-footer").style.display="block";
		//	document.getElementById("imageViewer").innerHTML=data;
			// block 풀고 image넣을 id가져와서 이미지 넣는다.
			
			
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:" + error);
		}
	});
}
