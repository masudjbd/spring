<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cars currently in the shop</title>
        <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">

    </head>
    <body>
        <h1>Cars currently in the shop</h1>
        <a class="pull-right btn btn-primary" href="<c:url value="j_spring_security_logout" />" > <i class="icon icon-white icon-off" ></i> Logout</a>

        <table class="table table-striped">
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                    <td>${car.color}</td>
                    <td><a  class="btn btn-primary" href="cars/${car.id}"><i class="icon icon-white icon-edit"></i> edit</a></td>
                </tr>
            </c:forEach>
        </table>

        <a class="btn btn-primary"  href="add"><i class="icon icon-white icon-plus-sign"></i> Add a Car</a>
        
    </body>
</html>