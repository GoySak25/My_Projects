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
<title>User Registration- Contact App</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<s:url value="/static/js/jquery-3.4.1.min.js" var="url_jQuery" />
<script type="text/javascript" src="${url_jQuery}"></script>
<script>
	function checkAvailability(){
		$.ajax({
			url:'checkAvail',
			data: {usName:$("#userName").val()},
			success: function(data){
				$('#result').html(data);
			}
		});
	}
</script>
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
				<h1>User Registration</h1>
				<c:if test="${err_message!=null}">			
					<p class="error">${err_message}</p>
				</c:if>
				
				<s:url var="url_registration" value="/register" />
				<f:form action="${url_registration}" modelAttribute="command"><!-- we didn't define the method here as in spring form the default method is post -->
					<table border="1">
						<tr>
							<td>Name</td>
							<td><f:input id="userName" path="user.user_name"/>
								<button type="button" onclick="checkAvailability()">Check Availability</button>
								<div id="result" class="error"></div>
							</td>
						</tr>
						<tr>
							<td>Email Address</td>
							<td><f:input path="user.email_address"/></td>
						</tr>
						<tr>
							<td>Phone Number</td>
							<td><f:input path="user.phone_number"/></td>
						</tr>
						<tr>
							<td>User Name</td>
							<td><f:input path="user.login_mane" /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><f:password path="user.password"/></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<button>Submit</button><br/>
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