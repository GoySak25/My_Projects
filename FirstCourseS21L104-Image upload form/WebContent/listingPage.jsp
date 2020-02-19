<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.entity.Files" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Listing page</title>
</head>
<body>
<h1>Image Listing page!!</h1>
<%! String form; %>
<table border="1" width="100%">
<tr>
<th>Preview</th>
<th>Available Information</th>
<th>Update Information</th>
<th>Action</th>
</tr>
<%
String path= request.getAttribute("path").toString();
List<Files> list= (List<Files>)request.getAttribute("files");
for(Files file:list){
	form= "<form action='ImageUpload' method='post'>"+
			"Label: <input type='text' name='label'/><br/><br/>"+
			"Caption: <input type='text' name='caption'/><br/><br/>"+
			"<input type='hidden' name='fileId' value='"+file.getId()+"'/>"+
			"<input type='hidden' name='action' value='updateImformation'/>"+
			"<input type='hidden' name='fileName' value='"+file.getFileName()+"'/>"+
		    "<input type='submit' value='Update'/>"+
			"</form>";
	out.print("<tr><td><img src="+path+file.getFileName()+" height='100%' width='100%'></td>");
	out.print("<td>"+
			"<ul>"+
			"<li>File ID:"+file.getId()+"</li>"+
			"<li>File Name:"+file.getFileName()+"</li>"+
			"<li>File Label:"+file.getLabel()+"</li>"+
			"<li>File Caption:"+file.getCaption()+"</li>"+
			"</ul>"+
			"</td>"+"<td>"+form+"</td>");
	out.print("<td><ul><li><a href='"+request.getContextPath()+"/ImageUpload?action=viewImage&fileId="+file.getId()+"'>View Full Image</a></li>");
	out.print("<li><a href='"+request.getContextPath()+"/ImageUpload?action=deleteImage&fileId="+file.getId()+"' onclick=\"if(!confirm('Are ou sure to delete the user?')) return false \">Delete Image</a></li></ul></td></tr>");
}

%>

</table>
</body>
</html>