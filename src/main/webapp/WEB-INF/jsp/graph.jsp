<!DOCTYPE html>
<html lang="en">
<title>Graph</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/dist/vis.js"></script>
    <script type="text/javascript" src="/js/graph.js"></script>
    <link href="/dist/vis.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        #mynetwork {
            height: 800px;
            border: 1px solid lightgray;
        }

        p {
            max-width:700px;
        }
    </style>

</head>
<body>
<jsp:include page="header.jsp"/>
<h2>The Recommender Graph</h2>
<div class="form-group  col-sm-8">
        <label for="domain">Domain:</label>
        <select class="form-control" id="domain" name="domain">
            <option>Movie</option>
            <option>Music</option>
            <option>Book</option>
            <option>Game</option>
        </select>
    <button type="button" class="btn btn-success" onclick="loadGraph()">Generate Graph</button>
</div>

<div id="mynetwork" class="col-sm-6" style="display:none"></div>
<div id="results" class="col-sm-6">
    <label id="salut"></label>
    <div id="ceauo"></div>
</div>

</body>
</html>