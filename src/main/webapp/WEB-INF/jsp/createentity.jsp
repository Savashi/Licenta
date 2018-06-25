<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<title>Create Entity</title>
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
    <h2>Create a new entity</h2>
    <form action="/createnewentity" method="post">
        <div class="form-group">
            <label for="domain">Domain:</label>
            <select class="form-control" id="domain" name="class">
                <option>Movie</option>
                <option>Music</option>
                <option>Book</option>
                <option>Game</option>
            </select>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="name" class="form-control" id="name" placeholder="Enter name" name="name">
        </div>
        <div class="form-group">
            <label for="type">Type:</label>
            <input type="type" class="form-control" id="type" placeholder="Enter type" name="type">
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div>
</body>
</html>