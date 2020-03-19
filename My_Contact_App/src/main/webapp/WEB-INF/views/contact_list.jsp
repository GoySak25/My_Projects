<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List- Contact App</title>
<s:url var="page_style" value="/static/css/style.css"></s:url>
<link href="${page_style}" rel="stylesheet" type="text/css">
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
				<h3>Contact List</h3>
				<c:if test="${param.action eq 'delete_contact'}">			
					<p class="success">Contact deleted successfully.</p>
				</c:if>
				<c:if test="${err_message!=null}">
					<p class="error">${err_message}</p>
				</c:if>	
				<table>
					<tr>
						<td align="right">
							<form action='<s:url value="/user/contact_search"></s:url>'>
								<input type="text" name="freeText" value="${param.freeText}" placeholder="Enter something to search" />
								<button>Find</button><br/><br/>
							</form>
						</td>				
					</tr>
				</table>				
				<form action='<s:url value="/user/bulk_delete" />'>
					<button>Delete Contacts</button><br><br>
					<table border="1" cellpadding="4" width="100%">
						<tr>
							<th>Select</th>
							<th>Contact ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Address</th>
							<th>Phone Number</th>
							<th>Remark</th>
							<th>Action</th>	
						</tr>
						<c:if test="${empty  contactList}">
							No records present!!
						</c:if>
						<c:forEach items="${contactList}" var="c">
							<tr>
								<td align="center"><input type="checkbox" name="delCheck" value="${c.contactID}"/></td>
								<td>${c.contactID}</td>
								<td>${c.name}</td>
								<td>${c.email}</td>
								<td>${c.address}</td>
								<td>${c.phone}</td>
								<td>${c.remark}</td>
								<s:url var="url_delete" value="/user/del_contact">
									<s:param name="conId" value="${c.contactID}"/>
								</s:url>
								<s:url var="url_edit" value="/user/edit_contact">
									<s:param name="editContId" value="${c.contactID}"/>
								</s:url>
								<td><a href="${url_edit}">Edit</a> | <a href="${url_delete}">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</form>
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