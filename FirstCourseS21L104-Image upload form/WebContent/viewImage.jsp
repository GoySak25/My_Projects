<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.project.entity.Files" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Image Page</title>
</head>
<body>
<%! Files files; String path; %>
<%files= (Files)request.getAttribute("files");
path= request.getAttribute("path").toString();	
%>
File Id: <%=files.getId() %> | File Name: <%= files.getFileName() %>
<%
if(files.getCaption()!=null){
	out.print(" | Caption:"+files.getCaption());
}
if(files.getLabel()!=null){
	out.print(" | Label:"+ files.getLabel());
}
%>
 | <a href="${pageContext.request.contextPath}">Home Page</a>
  | <a href="${pageContext.request.contextPath}/ImageUpload?action=listingPage">Listing Page</a>
  <hr/>
  <img src="<%= path+files.getFileName() %>" width="100%" height="100%" />
</body>
</html>