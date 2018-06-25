<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<title>Show Entities</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/entity.js"></script>
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
    <h2>Entity List</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Domain</th>
            <th>Name</th>
            <th>Type</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${entityDOS}" var="entity">
            <tr id="${entity.id}">
                <td>${entity.entityclass}</td>
                <td>${entity.name}</td>
                <td>${entity.type}</td>
                <td>
                    <button type="button" class="btn btn-default btn-primary">
                        <span class="glyphicon glyphicon-pencil"></span> <a class="no-a" href="/updatentity?id=${entity.id}">Edit </a>
                    </button>
                </td>
                <td>
                    <button onclick="deleteElement(${entity.id})" type="button" class="btn btn-default btn-danger">
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