<%@ page import="com.example.jakartaee_as4.StudentBean" %><%--
  Created by IntelliJ IDEA.
  User: MesKaNoVa
  Date: 14/04/2023
  Time: 3:50 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<script>
    function getValues() {
        let studentID = document.getElementsByName("studentID")[0].value;
        let studentName = document.getElementsByName("studentName")[0].value;
        let semester = document.getElementsByName("semester")[0].value;
        let cgpa = document.getElementsByName("cgpa")[0].value;
        window.location.href = "<%=request.getContextPath()%>/api/student/add?studentID="+studentID+"&studentName="+studentName+"&semester="+semester+"&cgpa="+cgpa;
    }
</script>
<body>
    <form>
        <label for="studentID">Student ID:</label>
        <input type="text" name="studentID" id="studentID" required>
        <br>
        <label for="studentName">Student Name:</label>
        <input type="text" name="studentName" id="studentName" required>
        <br>
        <label for="semester">Semester:</label>
        <select id="semester" name="semester" required>
            <option value="First">First</option>
            <option value="Second">Second</option>
            <option value="Third">Third</option>
            <option value="Fourth">Fourth</option>
            <option value="Fifth">Fifth</option>
            <option value="Sixth">Sixth</option>
            <option value="Seventh">Seventh</option>
            <option value="Eighth">Eighth</option>
        </select>
        <br>
        <label for="cgpa">CGPA:</label>
        <input type="text" name="cgpa" id="cgpa" required>
        <br>
        <button type="button" onclick="getValues()">Add</button>
        <br>
    </form>
</body>
</html>
