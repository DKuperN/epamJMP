<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 09.07.2016
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bicycle</title>
    <style>
        .menuelement{
            padding-top: 10px;
            font-size: 20pt;
        }
    </style>
</head>
<body>

    <center>
        <h1>HELLO! in web</h1>
        <h2>Velcome to Bicycle WORLD</h2>
    </center>

<menu>

    <div class="menuelement"><a href="viewbicycle">- search bicycle</a></div>
    <div class="menuelement"><a href="addordeletebicycle?edit=0">- add new bicycle to DB</a></div>
    <div class="menuelement"><a href="addordeletebicycle?edit=1">- remove bicycle from DB</a></div>
    <div class="menuelement"><a href="hello">- test Controller</a></div>

</menu>

</body>
</html>
