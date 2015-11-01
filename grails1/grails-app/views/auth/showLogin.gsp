<%--
  Created by IntelliJ IDEA.
  User: Thalita
  Date: 01/11/2015
  Time: 15:12
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Show Login</title>
</head>

<body>
<g:form name="showLogin" class="navbar-form navbar-left" controller="auth" action="login" id="1">
    <div class="form-group">
        <label for="name">Name</label>
        <g:textField class="form-control" name="name"></g:textField>
    </div>

    <div class="form-group">
        <label for="email">E-mail address</label>
        <g:textField class="form-control" name="email"></g:textField>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</g:form>
</body>
</html>