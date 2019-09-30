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
	font-size: 24px;
}

li {
	height: 50px;
	line-height: 50px;
	width: 150px;
	text-align: center;
	line-height: 50px;
}

li:hover {
	cursor: pointer;
	background-color: #eeeeee;
}
.hexagon:hover{
	filter:brightness(1.2);
}
.hexagon {
	text-align: center;
	display: inline-block;
	position: relative;
	width: 150px;
	height: 86.60px;
	background-color: antiquewhite;;
	margin: 43.30px 0;
	display: inline-block;
}

.hexagon:before, .hexagon:after {
	content: "";
	position: absolute;
	width: 0;
	border-left: 75px solid transparent;
	border-right: 75px solid transparent;
}

.hexagon:before {
	bottom: 100%;
	left: 0%;
	border-bottom: 43.30px solid antiquewhite;;
}

.hexagon:after {
	top: 100%;
	left: 0%;
	width: 0;
	border-top: 43.30px solid antiquewhite;;
	width: 0;
}
.hexagon span{
	font-size: 20px;
}
.hexagon a {
	color: orangered;
	font-size: 30px;
}

.hexagon a:hover {
	text-decoration: underline !important;
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
	<div style="height: 100px; line-height: 100px; width: 100%;padding:0 10px 0 10px;">
		헤더헤더헤더헤더
	</div>
	<div class="container" style="display: inline-block;">
		<div style="float: left; height: 100%; display: inline-block;">
			<ul style="list-style: none; padding: 0px; margin: 0px;; height: 100%;">
				<li>메뉴</li>
				<li>메뉴</li>
				<li>메뉴</li>
				<li>메뉴</li>
				<li>메뉴</li>
			</ul>
		</div>
		<div class="noti-area" style="display: inline-block;background-color: rgba(0,0,0,0.2);border-radius: 10px;margin-left: 50px;width: 470px;height:270px;padding: 30px;">
			<div class="hexagon"><span style="line-height: 40px;">요청<br><a style="text-decoration: none;" href="javascript:;"><%=noti_list.size() %></a></span></div>
		</div>
		
	</body>
</html>