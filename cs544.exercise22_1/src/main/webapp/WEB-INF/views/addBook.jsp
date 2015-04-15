<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Book</title>
        <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">

</head>
<body>
        <h3>Book Add</h3>

        <form:form modelAttribute="book" action="books" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />
	<table>
		<tr>
			<td>Title :</td>
			<td><form:input path="title" />
                            <form:errors path="title" cssClass="error" />
                        </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><form:input path="ISBN" /> 
                        <form:errors path="ISBN" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><form:input path="author" /> 
                        <form:errors path="author" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><form:input path="price" /> 
                        <form:errors path="price" cssClass="error" /></td>
		</tr>
	</table>
	<input class="btn btn-primary"  type="submit"/>
	
	</form:form>
</body>
</html>