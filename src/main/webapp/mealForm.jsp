<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meal Form</title>
</head>
<body>
<h2>${meal.id == null ? 'Create Meal' : 'Edit Meal'}</h2>

<form method="post">
    <div>
    <input hidden type="text" name="id" value="${meal.id}"><br>
    Date/Time: <input type="datetime-local" name="dateTime" value="${meal.dateTime}" required><br>
    Description: <input type="text" name="description" value="${meal.description}" required><br>
    Calories: <input type="number" name="calories" value="${meal.calories}" required><br>
    <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
