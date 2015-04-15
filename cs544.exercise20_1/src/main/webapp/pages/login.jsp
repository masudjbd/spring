<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet"
      href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                        <font color="red">
                        Your login attempt was not successful due to <br/><br/>
                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                        </font>
                    </c:if>
                    <form action="<c:url value="/j_spring_security_check"></c:url>"
                          method="post">

                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="User Name"
                                       name='j_username' type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password"
                                       name='j_password' type="password" value="">
                            </div>
                            <input class="btn btn-lg btn-success btn-block" type="submit"
                                   value="Login">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>