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
<div class="page-header">
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
<g:set var="params" value="[id: '${course.id}']"/>
<div class="row row-fluid">
    <app:isAuthenticated>
        <a href="${createLink(controller: 'course', action: 'register', params: params)}">
            <button type="button" class="btn btn-default navbar-btn navbar-right">Register</button>
        </a>
    </app:isAuthenticated>
</div>

<div class="panel panel-default">
    <div class="panel-heading"><h4><a href="#" id="toggleForm">Ask a Question</a>
    </h4></div>

    <div id="contactForm" class="toggleForm" style="display: none;">
        <div class="panel-body">
            <g:form name="contactHead" controller="course" action="contactHead">
                <div class="form-group">
                    <label for="from">E-mail</label>
                    <input id="from" type="email" class="form-control" name="from"/>
                </div>

                <div class="form-group">
                    <label for="body">Question</label>
                    <g:textArea class="form-control" name="body"></g:textArea>
                </div>
                <g:hiddenField name="id" value="${course.id}"/>
                <button type="submit" class="btn btn-default navbar-right">Submit</button>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>