<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login- User List</title>
<s:url var="page_style" value="/static/css/style.css"></s:url>
<link href="${page_style}" rel="stylesheet" type="text/css" />
<s:url value="/static/js/jquery-3.4.1.min.js" var="url_jQuery" />
<script type="text/javascript" src="${url_jQuery}"></script>
<script>
	function changeStatus(id, selected){
		$.ajax({
			url:'changeStatus',
			data: {userId:id, loginStatus:selected},
			success: function(data){
				alert(data);
			}
		})
	}
</script>
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
				<h3>User List</h3>
				<table border="1">
					<tr>
						<th>SR</th>
						<th>User ID</th>
						<th>Name</th>
						<th>Email Address</th>
						<th>Phone Number</th>
						<th>Login Name</th>
						<th>Login Status</th>
					</tr>
					<c:forEach var="u" items="${userList}" varStatus="st">
						<tr>
							<td>${st.count}</td>
							<td>${u.userID}</td>
							<td>${u.user_name}</td>
							<td>${u.email_address}</td>
							<td>${u.phone_number}</td>
							<td>${u.login_mane}</td>
							<td>
								<select id="id_${u.userID}" onchange="changeStatus(${u.userID}, $(this).val())">
									<option value="1">Active</option>
									<option value="2">Block</option>
								</select>
								<script>
									$("#id_${u.userID}").val('${u.login_status}');
								</script>
							</td>
						</tr>
					</c:forEach>
				</table>
				
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