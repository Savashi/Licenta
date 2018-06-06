<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<title>Update User</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/bootstrap-multiselect.min.css" type="text/css">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap-multiselect.js"></script>
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
    <h2>Update a user</h2>
    <form action="/action_page.php">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="name" class="form-control" id="name" placeholder="Enter name" name="name" value="${userDO.name}">
        </div>
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="surname" class="form-control" id="surname" placeholder="Enter surname" name="surname" value="${userDO.surname}">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value="${userDO.email}">
        </div>
        <div class="form-group">
            <label for="friends">Friends:</label><br/>
            <select id="example-filter-placeholder" class="form-control" name="friends" multiple="multiple">
                <c:forEach items="${userDOS}" var="user">
                    <c:set var="selected" value=""/>
                    <c:forEach items="${userDO.userList}" var="friend">
                        <c:if test="${user.id == friend.id}">
                            <c:set var="selected" value="selected"/>
                        </c:if>
                    </c:forEach>
                    <option value="${user.id}¶${user.surname}¶${user.name}¶${user.email}" ${selected}>${user.name}  ${user.surname}</option>
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
            <label for="entities">Entities:</label><br/>
            <select id="filter-placeholder" class="form-control" name="entities" multiple="multiple">
                <c:forEach items="${entityDOS}" var="entityDO">
                    <c:set var="selected" value=""/>
                    <c:forEach items="${userEntityDOS}" var="userentity">
                        <c:if test="${entityDO.id == userentity.entityDO.id}">
                            <c:set var="selected" value="selected"/>
                        </c:if>
                    </c:forEach>
                    <option value="${entityDO.id}¶${entityDO.entityclass}¶${entityDO.name}¶${entityDO.type}" ${selected}>${entityDO.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Update</button>
    </form>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#example-filter-placeholder').multiselect({
            enableFiltering: true,
            filterPlaceholder: 'Select a friend',
            enableCaseInsensitiveFiltering: true
        });
        $('#filter-placeholder').multiselect({
            enableFiltering: true,
            filterPlaceholder: 'Select an entity',
            enableCaseInsensitiveFiltering: true
        });
    });
</script>

</body>
</html>