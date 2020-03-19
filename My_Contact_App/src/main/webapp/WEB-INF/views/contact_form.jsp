<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Form- Contact App</title>
<s:url var="css_url" value="/static/css/style.css" />
<link href="${css_url}" rel="stylesheet" type="text/css" />
</head>
<body>
<%! String err_message=""; %>
<%
	if(request.getAttribute("err")!=null){
		err_message= request.getAttribute("err").toString();
	}
 %>
	<table border="1" width="80%" align="center">
		<tr>
			<td height= "80px">
				<!-- Header Area -->
				<jsp:include page="include/header.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height= "25px">
				<!-- Menu Area -->
				<jsp:include page="include/menu.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height= "350px">
				<!-- Page Content Area -->
				<h1>Contact Form</h1>
				<c:if test="${err_message!=null}">			
					<p class="error">${err_message}</p>
				</c:if>
				
				<s:url var="url_save" value="/user/save_contact" />
				<f:form action="${url_save}" modelAttribute="command"><!-- we didn't define the method here as in spring form the default method is post -->
					<table border="1">
						<tr>
							<td>Name</td>
							<td><f:input path="name"/></td>
						</tr>
						<tr>
							<td>Phone Number</td>
							<td><f:input path="phone"/></td>
						</tr>
						<tr>
							<td>Email Address</td>
							<td><f:input path="email"/></td>
						</tr>
						
						<tr>
							<td>Address</td>
							<td><f:textarea path="address" /></td>
						</tr>
						<tr>
							<td>Remark</td>
							<td><f:textarea path="remark"/></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<button>Save</button><br/>
							</td>
						</tr>
					</table>
				</f:form>
			</td>
		</tr>
		<tr>
			<td height= "25px">
				<!-- footer Area -->
				<jsp:include page="include/footer.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>