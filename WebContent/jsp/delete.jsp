<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<p style="text-align:center">会員情報削除画面</p>

<form action="../jp.co.aforce.servlet/delete" method="post">

	<p style="text-align: center">
		会員番号<input type="text" name="memberNo" required> <input
			type="submit" id="view" value="表示">
	</p>

	<p style="text-align: center">
		名前<input type="text" name="name" readonly>
	</p>
	<!--値を送信するreadonly  -->

	<p style="text-align: center">
		年齢<input type="text" name="age" readonly>
	</p>

	<p style="text-align: center">
		生年月日 <select name="birthYear">
			<option value=""></option>

		</select> <select name="birthMonth">
			<option value=""></option>

		</select> <select name="birthDay">
			<option value=""></option>

		</select>
	</p>

	<p style="text-align: center">
		<input type="button" id="back" onclick="history.back()" value="戻る">

		<input type="submit" id="delete" value="削除">
	</p>

</form>

<%@include file="../footer.html" %>