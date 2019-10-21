<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if((Integer)request.getAttribute("userCnt") > 0){
		response.sendRedirect("../home");
	}else{
		response.sendRedirect("../");
	}
%>