<%--
  Created by IntelliJ IDEA.
  User: MesKaNoVa
  Date: 14/04/2023
  Time: 3:54 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function getName()
    {
        let studentID = document.getElementsByName("studentID")[0].value;
        let studentName = document.getElementsByName("studentName")[0].value;
        window.location.href = "<%=request.getContextPath()%>/api/student/update?studentID="+studentID+"&studentName="+studentName;
    }
</script>
<body>
    <form>
        <input type="text" placeholder="Enter student ID here" name="studentID" required>
        <br>
        <input type="text" placeholder="Enter student new Name here" name="studentName" required>
        <br>
        <button type="button" onclick="getName()">Update!</button>
    </form>
</body>
</html>
