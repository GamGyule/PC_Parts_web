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

.noti-area{
	display: inline-block;
	float:left;
	width:400px;
	height: 100px;
	background-color: rgba(0,0,0,0.2);
	border-radius: 15px;
	padding:50px;
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
  background: #ABF8FF;
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
  color: #000000;
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
	int noti_cnt = 0;
	List<NotiDTO> noti_list = null;
	if (request.getAttribute("noti_list") != null) {
		noti_list = (List<NotiDTO>) request.getAttribute("noti_list");
	}
%>
<body style="margin: 0; padding: 0;">
	<div style="height: 100px; line-height: 100px; width: 100%;padding:0 10px 0 10px; background-color:rgba(230,230,230,0.4);box-sizing: border-box;">
		<span>관리하자</span>
	</div>
	<div class="container" style="display: inline-block;width:100%;">
		<div style="float: left; height: 100%; display: inline-block;">
			<ul style="list-style: none; padding: 0px; margin: 0px;; height: 1200px;">
				<li>메뉴</li>
				<li>메뉴</li>
				<li>메뉴</li>
				<li>메뉴</li>
				<li>메뉴</li>
			</ul>
		</div>
		<div class="noti-area">
			<div class="frame">
				<div class="hex-outer h1"></div>
				<div class="hex-outer h2"></div>
				<div class="hex-outer h3"></div>
				<div class="label"><span style="font-size:24px;">요청<br><a class="noti-cnt" style="text-decoration: none;color:orangered;" href="javascript:;"><%=noti_list.size() %></a></span></div>
			</div>
			<div class="frame">
				<div class="hex-outer h1"></div>
				<div class="hex-outer h2"></div>
				<div class="hex-outer h3"></div>
				<div class="label"><span style="font-size:24px;">요청<br><a class="noti-cnt" style="text-decoration: none;color:orangered;" href="javascript:;"><%=noti_list.size() %></a></span></div>
			</div>
			<div class="frame">
				<div class="hex-outer h1"></div>
				<div class="hex-outer h2"></div>
				<div class="hex-outer h3"></div>
				<div class="label"><span style="font-size:24px;">요청<br><a class="noti-cnt" style="text-decoration: none;color:orangered;" href="javascript:;"><%=noti_list.size() %></a></span></div>
			</div>
		</div>
		
	</body>
</html>