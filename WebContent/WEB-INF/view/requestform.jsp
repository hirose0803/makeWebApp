<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String msg=(String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>リクエストフォーム</title>
<style>
.back{
padding-top:20px;
padding-bottom:60px;
background:#ffffdb;
min-height:100vh;
}
form{
margin:2px auto 2px 10%;
font-size:20px;
}
a{
margin:2px auto 2px 10%;
font-size:20px;
}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div id="container">
<div id="back">
<%if(msg!=null){ %>
<div class="alert alert-success" role="alert">
<%=msg %>
</div>
<%} %>
<form action="InsertReq" method="post">
<div class="form-group">
<label for="req">リクエストしたい単語</label><input type="text" name="req" id="req" class="form-group" required>
</div>
<button type="submit" class="btn btn-primary">送信</button>
</form>
<a href="Main">戻る</a>
</div>
</div>
</body>
</html>