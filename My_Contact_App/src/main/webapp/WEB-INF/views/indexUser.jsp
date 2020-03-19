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
<title>User Login- Contact App</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
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
				<h1>User Login</h1>
				<c:if test="${param.action eq 'logout'}">			
					<p class="success">Logout Successfully! Thanks for using contact application.</p>
				</c:if>
				<c:if test=" ${err_message.length()!=0}">			
					<p class="error">${err_message}</p>
				</c:if>
				<c:if test="${param.action eq 'registration' }">			
					<p class="success">User Registered Successfully! Please Login.</p>
				</c:if>
				<s:url var="u_login" value="/login" />
				<f:form action="login" modelAttribute="command"><!-- we didn't define the method here as in spring form the default method is post -->
					<table border="1">
						<tr>
							<td>User Name</td>
							<td><f:input path="loginName" /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><f:password path="password"/></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<button>Login</button><br/>
								<a href="registration_form">New User Registration</a>
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