<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Roboto&display=swap" rel="stylesheet">
<style>
html, body {
	font-family: 'Nanum Gothic', sans-serif;
	font-family: 'Roboto', sans-serif;
	font-size: 18px;
}

.noti-area{
	display: inline-block;
	float:left;
	width:400px;
	height: 135px;
	padding:50px;
	border:1px solid gray;
	border-radius:3px;
}

li {
	height: 50px;
	line-height: 50px;
	width: 210px;
	text-align: center;
	line-height: 50px;
}

li:hover {
	cursor: pointer;
	background-color: #eeeeee;
}

.frame{
  width: 110px;
  margin: 0 auto;
  margin-right:10px;
  display:inline-block;
  position: relative;
  cursor: pointer;
  float:left;
  top:20px;
  left:15px;
}

.frame:hover .hex-inner{
  height: 100px;
  top: 90px !important;
  border-radius: 4px;
}

.frame:hover .label{
  transform: scale(.95);
  -webkit-transform: scale(.95);
}

.hex-outer{
  background: #fdcb6e;
  width: 110px;
  height: 64px;
}

.h1{
  position: absolute;
}

.h2{
  position: absolute;
  transform: rotate(60deg);
  -webkit-transform: rotate(60deg);
}

.h3{
  position: absolute;
  transform: rotate(-60deg);
  -webkit-transform: rotate(-60deg);
}

.label{
  position: relative;
  color: white;
  font-weight: bold;
  text-align:center;
  left: 0px;
    transition: all .1s;
  -webkit-transition: all .1s;
}

.frame:hover .noti-cnt{
  text-decoration: underline!important;
}

.frame:hover .noti-cnt{
   text-decoration: underline!important;
}

.noti-cnt{
	font-size:24px;
}

.noti-area{
	position: absolute;
}

.h2c-bar{
	border:2px solid #f39c12;
	margin:0px;
}

.list-table{
	border-collapse: collapse;
}
.list-table tr{
	border-bottom: 1px solid black;
}

.list-table th{
	border-bottom: 2px solid black;
}
.list-table th:nth-child(1){
	width:100px;
}
.list-table th:nth-child(2){
	width:300px;
}
.list-table th:nth-child(3){
	width:100px;
}
.list-table th:nth-child(4){
	width:100px;
}

.list-table td:nth-child(3){
	text-align: right;
}
.list-table td:nth-child(4){
	text-align: right;
}

</style>
<meta charset="UTF-8">
<title>관리하자</title>
</head>
<body style="margin: 0; padding: 0;">
	<div style="height: 100px;color:white; line-height: 100px; width: 100%;padding:0 10px 0 10px;box-sizing: border-box;font-size: 32px;background-color:#fdcb6e;">
		<img width="50" src="<%=request.getContextPath() %>/images/admin_icon.png"/><span>PC_Parts 관리자</span>
	</div>
<!-- 	<hr class="h2c-bar"> -->
	<div class="container" style="display: inline-block;width:100%;">
		<div style="float: left; height: 100%; display: inline-block;">
			<ul style="list-style: none; padding: 0px; margin: 0px;; height: 1200px;">
				<li>홈</li>
				<li>재고 관리</li>
				<li>입·출고 관리</li>
				<li>통계 관리</li>
				<li>재고 요청</li>
			</ul>
		</div>
		<div class="list-area" style="padding:5px;">
			<table class="list-table">
				<thead>
					<th>요청</th><th>제품 이름</th><th>제품 번호</th><th>개수</th>
				</thead>
					<tr><td>AAAA</td><td>제품 이름</td><td>2</td><td>20</td></tr>
					<tr><td>AAAA</td><td>제품 이름</td><td>1</td><td>52</td></tr>
					<tr><td>AAAA</td><td>제품 이름</td><td>20</td><td>17</td></tr>
					<tr><td>AAAA</td><td>제품 이름</td><td>47</td><td>3</td></tr>
				
			</table>
		</div>
		
	</body>
</html>