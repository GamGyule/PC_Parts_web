<%@page import="com.pc.parts.dto.CompanyDTO, java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getAttribute("list") != null){
		List<CompanyDTO> list = (List<CompanyDTO>)request.getAttribute("list");
		if(list.isEmpty()){
			%>
				<script>
					alert("아이디 또는 비밀번호가 다릅니다.");
					location.href="/";
				</script>
			<%
		}else{
			CompanyDTO dto = list.get(0);
			session.setAttribute("user", dto);
			response.sendRedirect("../home");
		}
	}else{
		response.sendRedirect("../");
	}
%>