<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<title>Update Entity</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <h2>Update an entity</h2>
    <form action="/action_page.php">
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
            <label for="name">Name:</label>
            <input type="name" class="form-control" id="name" placeholder="Enter name" name="name" value="${entityDO.name}">
        </div>
        <div class="form-group">
            <label for="type">Type:</label>
            <input type="type" class="form-control" id="type" placeholder="Enter type" name="type" value="${entityDO.type}">
        </div>
        <button type="submit" class="btn btn-success">Update</button>
    </form>
</div>
</body>
</html>