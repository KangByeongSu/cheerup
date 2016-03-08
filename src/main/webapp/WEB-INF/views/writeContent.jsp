<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

	<link rel="stylesheet" href="<c:url value='/resources/css/writeContent.css' />" type="text/css" />


<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<!-- remove this if you use Modernizr -->
<script>
	(function(e, t, n) {
		var r = e.querySelectorAll("html")[0];
		r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2")
	})(document, window, 0);
</script>

</head>
<body>
	<section id="container">
	<div class="upload-header">
		<span class="upload-header-text">Instagram Upload</span>
	</div>
	<div class="upload-content">
		<div class="upload-content-image">
			<div class="content">

				<div class="box">
					<form name="uploadForm" action="javascript:imageUploadAjax();"
						method="post" enctype="multipart/form-data">
						<input type="file" name="file-2[]" id="file-2"
							class="inputfile inputfile-2"
							data-multiple-caption="{count} files selected" multiple /> <label
							for="file-2"><svg xmlns="http://www.w3.org/2000/svg"
								width="20" height="17" viewBox="0 0 20 17"> <path
								d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z" /></svg>
							<span>Choose a file&hellip;</span></label>
					</form>
				</div>

			</div>
			<div class="upload-content-text">dd</div>
		</div>
		<div class="upload-footer">
			<div class="upload-footer-text">SK플래닛 Team Elephant</div>
			<div class="upload-footer-post">
				<img src=<c:url value='/resources/img/post-button.png' /> />
			</div>
		</div>
		<section> <script
			src=<c:url value="/resources/js/writeContent.js"/>></script>
</body>
</html>