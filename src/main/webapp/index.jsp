<%--
  Created by IntelliJ IDEA.
  User: MesKaNoVa
  Date: 14/04/2023
  Time: 3:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index Page</title>
</head>
<body>
    <h3>Choose an operation:</h3>
    <h4>
        <ol>
            <li><a href="addStudent.jsp">Add new student</a></li>
            <li><a href="findStudent.jsp">Find a student name</a></li>
            <li><a href="compareStudent.jsp">Compare between two students</a></li>
            <li><a href="updateStudent.jsp">Update a student name</a></li>
            <li><a href="<%=request.getContextPath()%>/api/student/highest-cgpa">Find highest cgpa</a></li>
        </ol>
    </h4>
</body>
</html>
