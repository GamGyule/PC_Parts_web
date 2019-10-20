<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.pc.parts.dto.NotiDTO,java.util.List"%>
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
a{
	text-decoration: none;
	color:black;
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

.tab-select{
	background-color: #fdcb6e;
}

li:hover {
	cursor: pointer;
	background-color: #fcdb9d;
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

</style>
<meta charset="UTF-8">
<title>관리하자</title>
</head>
<%
	/*int noti_cnt = 0;
	List<NotiDTO> noti_list = null;
	if (request.getAttribute("noti_list") != null) {
		noti_list = (List<NotiDTO>) request.getAttribute("noti_list");
	}*/
%>
<body style="margin: 0; padding: 0;">
	<div style="height: 100px;color:white; line-height: 100px; width: 100%;padding:0 10px 0 10px;box-sizing: border-box;font-size: 32px;background-color:#fdcb6e;">
		<img width="50" src="images/admin_icon.png"/><span>PC_Parts 관리자</span>
	</div>
<!-- 	<hr class="h2c-bar"> -->
	<div class="container" style="display: inline-block;width:100%;">
		<div style="float: left; height: 100%; display: inline-block;">
			<ul style="list-style: none; padding: 0px; margin: 0px;; height: 1200px;">
				<a href="javascript:;"><li class="tab-select">홈</li></a>
				<a href="./productManaging"><li>재고 관리</li></a>
				<a href="javascript:;"><li>입·출고 관리</li></a>
				<a href="javascript:;"><li>통계 관리</li></a>
				<a href="javascript:;"><li>재고 요청</li></a>
			</ul>
		</div>
		<div class="noti-area">
			<div class="frame">
				<div class="hex-outer h1"></div>
				<div class="hex-outer h2"></div>
				<div class="hex-outer h3"></div>
				<div class="label"><span style="font-size:20px;">받은 요청<br><a class="noti-cnt" style="text-decoration: none;color:white;" href="javascript:;">2</a></span></div>
			</div>
			<div class="frame">
				<div class="hex-outer h1"></div>
				<div class="hex-outer h2"></div>
				<div class="hex-outer h3"></div>
				<div class="label"><span style="font-size:20px;">재고 부족<br><a class="noti-cnt" style="text-decoration: none;color:white;" href="javascript:;">2</a></span></div>
			</div>
			<div class="frame">
				<div class="hex-outer h1"></div>
				<div class="hex-outer h2"></div>
				<div class="hex-outer h3"></div>
				<div class="label"><span style="font-size:20px;">판매<br><a class="noti-cnt" style="text-decoration: none;color:white;" href="javascript:;">2</a></span></div>
			</div>
		</div>
		
	</body>
</html>