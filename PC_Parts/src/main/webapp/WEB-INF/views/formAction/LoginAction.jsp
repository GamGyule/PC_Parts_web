<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="com.pc.parts.dto.CompanyDTO,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	List<CompanyDTO> com = (List<CompanyDTO>)request.getAttribute("com");
	if(com.size() > 0){
		session.setAttribute("com", com.get(0));
		CompanyDTO c1 = (CompanyDTO)session.getAttribute("com");
		if(request.getAttribute("com") != null){
			String url = request.getAttribute("com").toString();
			response.sendRedirect(url);
		}else{
			response.sendRedirect("../");
		}
		
	}else{
		%>
		<script>
			location.href="../login";
			alert("입력하신 계정 이름이나 비밀번호가 올바르지 않습니다.");
		</script>
		<%
	}
%>
</body>
</html>