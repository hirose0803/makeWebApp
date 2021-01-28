<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*" %>
    <%
    List<Slang> list=(List<Slang>)request.getAttribute("list");
    String value=(String)request.getAttribute("value");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MMOSlang</title>
 <link rel="stylesheet" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
  <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
<div id="container">
<h1>MMOで出てくる英語スラング</h1>
<form action="Main" method="post">
カテゴリ選択<br>
<input type="radio" name="type" value="0" <%if(value.equals("0")){ %>checked<%} %>>全て
<input type="radio" name="type" value="1" <%if(value.equals("1")){ %>checked<%} %>>日常会話
<input type="radio" name="type" value="2" <%if(value.equals("2")){ %>checked<%} %>>戦闘用語
<input type="radio" name="type" value="3" <%if(value.equals("3")){ %>checked<%} %>>募集文
<input type="radio" name="type" value="4" <%if(value.equals("4")){ %>checked<%} %>>その他
<button type="submit">検索</button>
</form>
<table border="1">
<%for(Slang s:list){ %>
<tr><th><%=s.getTitle() %></th><td><%=s.getBody() %></td></tr>
<%} %>
</table>
<a href="InsertReq">単語登録のリクエストはコチラ</a>
</div>
</body>
</html>