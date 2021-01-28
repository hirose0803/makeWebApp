<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*" %>
    <%
    List<Slang> list=(List<Slang>)request.getAttribute("list");
    List<Request> reqlist=(List<Request>)request.getAttribute("reqlist");
    String msg=(String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MMOSlang</title>
<style>
.container{
padding-top:20px;
padding-bottom:60px;
}
h1{
font-size:3vw;
text-align:center;
}
form{
width:500px;
margin:5px auto 5px 10%
}
table{
width:90%;
}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>MMO英語スラング管理画面</h1>
<%if(msg!=null){ %>
<div class="alert alert-success" role="alert">
<%=msg %>
</div>
<%} %>
<form class="mt-3" action="Admin" method="post">
新しく単語を登録<br>
<div class="form-group">
<label for="title">登録したい単語:</label><input type="text" name="title" id="title" class="form-group" required>
</div>
<div class="form-group">
<label for="body">意味:</label><br><textarea name="body" rows="4" cols="40" id="body" class="form-group" required></textarea>
</div>
カテゴリ選択<br>
<input type="radio" name="type" value="1" required>日常会話
<input type="radio" name="type" value="2" required>戦闘用語
<input type="radio" name="type" value="3" required>募集文
<input type="radio" name="type" value="4" required>その他
<button type="submit" class="btn btn-primary">登録</button>
</form>
<a href="Main" class="btn btn-online-info btn-primary float-right">公開ページを見る</a><br>
<%if(reqlist!=null && reqlist.size()>0){ %>
<p>単語登録のリクエスト</p>
<table class="table table-borderd mt-5">
<%for(Request r:reqlist){ %>
<tr>
<th><%=r.getReq() %></th>
<td>
<a href="DeleteReq?req=<%=r.getReq() %>" onclick="return confirm('削除してよろしいですか？')">削除</a>
</td>
</tr>
<%} %>
<%} %>
<%if (list!=null && list.size()>0){ %>
<table class="table table-bordered mt-5">
<%String[] arr={"日常会話","戦闘用語","募集文","その他"}; %>
<%for(Slang s:list){ %>
<tr>
<th><%=s.getTitle() %></th>
<td><%=s.getBody() %></td>
<td><%=arr[s.getType()-1] %></td>
<td>
<a href="Update?id=<%=s.getId() %>">編集</a>
</td>
<td>
<a href="Delete?id=<%=s.getId() %>" onclick="return confirm('削除してよろしいですか？')">削除</a>
</tr>
<%} %>
</table>
<%} %>
</div>
</body>
</html>