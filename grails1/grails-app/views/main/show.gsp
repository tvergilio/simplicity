<%--
  Created by IntelliJ IDEA.
  User: Thalita
  Date: 31/10/2015
  Time: 15:01
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Courses</title>
</head>

<body>
<div class = "page-header">
    <h1>Course</h1>
</div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">${course.title}</h3>
        </div>
        <div class="panel-body">
            Code:  ${course.code} <br/>
            Description: ${course.description} <br>
            Faculty: <g:link controller="faculty" action="show" id="${course.faculty.id}">${course.faculty.name}</g:link>
        </div>
    </div>
</body>
</html>