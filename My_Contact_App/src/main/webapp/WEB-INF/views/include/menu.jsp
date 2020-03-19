<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<s:url var="url_logout" value="/logout"></s:url>
<s:url var="url_reg_form" value="/registration_form"></s:url>

<c:if test="${sessionScope.userId==null}">
	<a href='/My_Contact_App'>Home</a> | <a href='/My_Contact_App'>Login</a> | <a href="${url_reg_form}">Registration</a> | <a href='#'>About</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
	<s:url var="admin_home" value="/admin/dashboard"></s:url>
	<a href='${admin_home}'>Home</a> | <a href='<s:url value="/admin/users"/>'>User List</a> | <a href="${url_logout}">Logout</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">
<s:url var="user_home" value="/user/dashboard"></s:url>
<s:url var="url_contact_form" value="/user/contact_form"></s:url>
<s:url value="/user/contact_list" var="url_contact_list"></s:url>
	<a href='${user_home}'>Home</a> | <a href='${url_contact_form}'>Add Contact</a> | <a href='${url_contact_list}'>Contact List</a>  | <a href="${url_logout}">Logout</a>
</c:if>