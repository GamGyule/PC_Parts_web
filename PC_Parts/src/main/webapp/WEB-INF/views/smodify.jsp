<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html, body{
	margin:0px;
	padding:0px;
}
input {
	padding: 5px;
	margin:0px;
	display: inline;
	vertical-align: bottom;
	box-shadow: none;
}

.idx {
	width: calc(50% - 15px);
	background-color:#D8D8D8;
	height: 25px;
}

.pname {
	width: calc(100% - 15px);
	height: 25px;
}

.pcontent {
	min-width:calc(100% - 7px);
	max-width:calc(100% - 7px);
	width: calc(100% - 7px);
	height:150px;
	font-size: 18px;
}

.price {
	width: calc(50% - 15px);
	height: 25px;
}
.input-area{
	padding:10px;
	width:400px;
}

.btn-area{
	text-align: center;
}
.pbtn{
	width:100px;
	height:40px;
}
</style>
</head>
<body>
	<div class="input-area">
	<form method="post">
		<input class="idx" type="text" value="IDX" readonly="on"><input class="price" type="text" value="가격"><br><br>
		<input class="pname" type="text" value="부품 이름"><br><br>
		<textarea class="pcontent"></textarea>
		<div class="btn-area">
			<input class="pbtn" type="button" value="삭제">	<input class="pbtn" type="button" value="수정">	<input class="pbtn" onclick="window.close()" type="button" value="닫기">
		</div>
	</form>
	</div>
	
</body>
</html>