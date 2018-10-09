<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<html>
<head>
    <title>Meals</title>
    <style>
        table, th, td {
            border: 2px solid black;
            border-collapse: collapse;
            padding: 10px;
            text-align: left;
        }
        th {
            background: #bab9ba;
        }
        .red {
            background: #ffc8cf;
            color: red;
        }
        .green {
            background: #d4ffc5;
            color: green;
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<br>
<a href="meals?action=create">Add meal</a>
<br>
<br>

<table>
    <tr>
        <th>Date/Time</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${listMeals}" var="mealWithExceed">
        <tr class="${mealWithExceed.exceed ? 'red' : 'green'}">
            <td><javatime:format value="${mealWithExceed.dateTime}" pattern="yyyy-MM-dd HH:mm"/></td>
            <td>${mealWithExceed.description}</td>
            <td>${mealWithExceed.calories}</td>
            <td><a href="meals?action=update&id=${mealWithExceed.id}">Edit</a></td>
            <td><a href="meals?action=delete&id=${mealWithExceed.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
