<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image upload form</title>
</head>
<body>
	<form action="ImageUpload?action=fileUpload" method="post" enctype="multipart/form-data">
		Select images: <input type="file" name="files" multiple/>
		<input type="submit" value="Upload"/>
	</form>
	<a href="${pageContext.request.contextPath}/ImageUpload?action=listingPage">View Images</a>
</body>
</html>