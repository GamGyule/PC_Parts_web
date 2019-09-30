<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.pc.parts.dto.NotiDTO,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Roboto&display=swap" rel="stylesheet">
<style>

html,body{
	font-family: 'Nanum Gothic', sans-serif;
	font-family: 'Roboto', sans-serif;
}

#hexagon {
    width: 90px;
    height: 55px;
    background: antiquewhite;
    position: relative;
    text-align: center;
    transform: rotate(90deg);
}

#hexagon:before {
	content: "";
    position: absolute;
    top: -25px;
    left: 0;
    width: 0;
    height: 0;
    border-left: 45px solid transparent;
    border-right: 45px solid transparent;
    border-bottom: 25px solid antiquewhite;
}

#hexagon:after {
	content: "";
    position: absolute;
    bottom: -25px;
    left: 0;
    width: 0;
    height: 0;
    border-left: 45px solid transparent;
    border-right: 45px solid transparent;
    border-top: 25px solid antiquewhite;
}

li {
	height: 34px;
	line-height: 34px;
	width: 150px;
	text-align: center;
}

li:hover {
	cursor: pointer;
	background-color: #eeeeee;
}

#hexagon span a:hover{
	text-decoration: underline!important;
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
	<div style="height: 50px; line-height: 50px; width: 100%;">
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
		<div class="noti_area" style="width: 400px; height: 220px; border: 1px solid black; display: inline-block; padding: 10px;padding-top:23px;">
			<!-- style="float: left;border: 1px solid gray; width: 100px; height: 100px; text-align: center;display: inline-block;line-height: 35px;border-radius: 50px;" -->
			<div id="hexagon">
				<span style="display:block;transform: rotate(-90deg);">요청<br>
				<a style="text-decoration: none; color: red; font-size: 30px;" href="javascript:;"><%=noti_list.size()%></a></span>
			</div>
		</div>

	</div>

</body>
</html>