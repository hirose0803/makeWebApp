<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*" %>
    <%
    Slang slang=(Slang)request.getAttribute("slang");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container{
padding-top:20px;
padding-bottom:60px;
}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
<form class="mt-3" action="Update" method="post">
<div class="form-group">
<label for="title">編集したい単語:</label><input type="text" name="title" id="title" class="form-group" value="<%=slang.getTitle()%>" required>
</div>
<div class="form-group">
<label for="body">意味:</label><textarea name="body" id="body" class="form-group" rows="4" cols="40" required><%=slang.getBody() %></textarea>
</div>
カテゴリ選択:<input type="radio" name="type" value="1" <%if(slang.getType()==1){ %>checked<%} %> required>日常会話
<input type="radio" name="type" value="2" <%if(slang.getType()==2){ %>checked<%} %> required>戦闘用語
<input type="radio" name="type" value="3" <%if(slang.getType()==3){ %>checked<%} %> required>募集文
<input type="radio" name="type" value="4" <%if(slang.getType()==4){ %>checked<%} %> required>その他
<input type="hidden" name="id" value="<%=slang.getId() %>">
<button type="submit" class="btn btn-primary">登録</button>
</form>
</div>
</body>
</html>