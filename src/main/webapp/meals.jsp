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

<table>
    <tr>
        <th>Date/Time</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <c:forEach items="${listMeal}" var="meal">
        <tr class="${meal.exceed ? 'red' : 'green'}">
            <td><javatime:format value="${meal.dateTime}" pattern="yyyy-MM-dd HH:mm"/></td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
