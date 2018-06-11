<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<title>Create User</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/bootstrap-multiselect.min.css" type="text/css">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap-multiselect.js"></script>
    <script src="/js/user.js"></script>
    <style>
        .multiselect.dropdown-toggle {
            width: 40%;
        }
        .multiselect-native-select {
            width: 100%;
        }
        .multiselect-native-select .btn-group{
            width: 100%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <h2>Create a new user</h2>
    <form action="/action_page.php">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="name" class="form-control" id="name" placeholder="Enter name" name="name">
        </div>
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="surname" class="form-control" id="surname" placeholder="Enter surname" name="surname">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
        <div class="form-group">
            <label for="friends">Friends:</label><br/>
            <select id="example-filter-placeholder" class="form-control" name="friends" multiple="multiple">
                <c:forEach items="${userDOS}" var="user">
                    <option value="${user.id}¶${user.surname}¶${user.name}¶${user.email}">${user.name}  ${user.surname}</option>
                    <td>${user.surname}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="domain">Domain:</label>
            <select class="form-control" id="domain" name="class">
                <option>Movie</option>
                <option>Music</option>
                <option>Book</option>
                <option>Gaming</option>
            </select>
        </div>
        <div class="form-group">
            <label for="entities">Entities:</label>
            <span style="cursor:pointer" class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="right" title="Configure Ratings"></span>
            <br/>
            <select id="filter-placeholder" class="form-control" name="entities" multiple="multiple">
                <c:forEach items="${entityDOS}" var="entity">
                    <option value="${entity.id}--${entity.entityclass}--${entity.name}--${entity.type}"-->${entity.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Rate Entities</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
            </div>
        </div>
    </div>
</div>
</body>
</html>