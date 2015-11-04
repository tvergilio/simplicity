<%--
  Created by IntelliJ IDEA.
  User: Thalita
  Date: 01/11/2015
  Time: 18:27
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Student</title>
</head>

<body>
<div class="page-header">
    <h1>${student.name}</h1>
</div>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Courses</h3>
    </div>

    <div class="panel-body">
        <g:render template="/main/course" collection="${student.courses}" var="course"/>
    </div>
</div>
</body>
</html>