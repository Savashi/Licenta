<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<title>Show Users</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/user.js"></script>
    <style>
        .no-a {
            color: white!important;
            text-decoration: none;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <h2>User List</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Surname</th>
            <th>First Name</th>
            <th>Email</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userDOS}" var="user">
            <tr id="${user.id}">
                <td>${user.surname}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>
                    <button type="button" class="btn btn-default btn-primary">
                        <span class="glyphicon glyphicon-pencil"></span> <a class="no-a" href="/updateuser?id=${user.id}">Edit </a>
                    </button>
                </td>
                <td>
                    <button  onclick="deleteUser(${user.id})" type="button" class="btn btn-default btn-danger">
                        <span class="glyphicon glyphicon-trash"></span> Delete
                    </button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>


</div>
</body>
</html>