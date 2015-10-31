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
    <h1>Course List</h1>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <g:form class="input-group" controller="main" action="search">
                <g:textField type="text" name="searchString" class="form-control"
                             placeholder="Search for course..."></g:textField>
                <span class="input-group-btn">
                    <g:actionSubmit class="btn btn-default" type="button" value="Search"/>
                </span>
            </g:form><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

&nbsp;
<g:render template="course" collection="${courses}" var="course"/>
</div>
</body>
</html>