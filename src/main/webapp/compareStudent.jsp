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
    <title>Compare 2 Students</title>
</head>
<script>
    function getIDs()
    {
        let firstID = document.getElementsByName("firstID")[0].value;
        let secondID = document.getElementsByName("secondID")[0].value;
        window.location.href = "<%=request.getContextPath()%>/api/student/compare?firstID="+firstID+"&secondID="+secondID;
    }
</script>
<body>
    <form>
        <input type="text" placeholder="First Student ID" name="firstID" required>
        <p> VS. </p>
        <input type="text" placeholder="Second Student ID" name="secondID" required>
        <br>
        <button type="button" onclick="getIDs()">Compare!</button>
    </form>
</body>
</html>
