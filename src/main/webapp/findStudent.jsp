<%--
  Created by IntelliJ IDEA.
  User: MesKaNoVa
  Date: 14/04/2023
  Time: 3:53 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find A Student</title>
</head>
<script>
    function getID() {
        let studentID = document.getElementsByName("studentID")[0].value;
        window.location.href = "<%=request.getContextPath()%>/api/student/" + studentID + "/studentName";
    }
</script>
<body>
    <form>
        <input type="text" placeholder="Enter student ID" name="studentID" required>
        <button type="button" onclick="getID()">Find!</button>
    </form>
</body>
</html>
