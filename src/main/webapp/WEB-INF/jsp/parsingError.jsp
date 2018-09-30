<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
	<div class="file-uploader__message-area">
		<h1>Something went wrong!</h1>
		<h2>File you are trying to upload is corrupt, check for any
			missing fields</h2>
		<h2>${message}</h2>
		<a href="/">Go Home</a>
	</div>
</body>
</html>