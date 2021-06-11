<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<p style="text-align:center">メニュー画面</p>

<form action="regist.jsp" method="post">

<p id="regist" style="text-align:center"><input type="submit" value="会員情報新規登録"></p>

</form>

<form action="update.jsp" method="post">

<p id="update" style="text-align:center"><input type="submit" value="会員情報変更"></p>

</form>

<form action="delete.jsp" method="post">

<p id="delete" style="text-align:center"><input type="submit" value="会員情報削除"></p>

</form>

<%@include file="../footer.html" %>

