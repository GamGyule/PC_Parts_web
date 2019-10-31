<%@page import="com.pc.parts.dto.CompanyDTO"%>
<%@page import="com.pc.parts.dto.SuppleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 관리</title>
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
	width: calc(33% - 15px);
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
	width: calc(33% - 15px);
	height: 25px;
	text-align: right;
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
<script>
	function SDelete(idx){
		var myForm = document.SDeleteForm;
		var url = "/sdelete";
		myForm.action = url;
		myForm.method = "post";
		myForm.suppleIdx.value = idx;
		myForm.submit();
		
		opener.location.reload();
		
		window.close();
	}
	
	function SUpdate(idx){
		var myForm = document.SDeleteForm;
		var url = "/supdate";
		myForm.action = url;
		myForm.method = "post";
		myForm.suppleIdx.value = idx;
		
		myForm.supplePrice.value = document.querySelector("#sPrice").value;
		myForm.suppleCount.value = document.querySelector("#sCnt").value;
		myForm.suppleName.value = document.querySelector("#sName").value;
		myForm.suppleInfo.value = document.querySelector("#sInfo").value;
		
		myForm.submit();
		opener.location.reload();
		window.close();
	}
</script>
</head>
<body>
<%
	SuppleDTO supple = null;
	if(request.getAttribute("supple") != null){
		supple = (SuppleDTO)request.getAttribute("supple");
	}
	CompanyDTO user = (CompanyDTO)session.getAttribute("user");
%>
	<div class="input-area">
		<form name="SDeleteForm">
			<input type="hidden" name="suppleIdx">
			
			<input type="hidden" name="supplePrice">
			<input type="hidden" name="suppleCount">
			<input type="hidden" name="suppleName">
			<input type="hidden" name="suppleInfo">
		</form>
		
		<%
			if(supple.getIdx().substring(0,4).equals(user.getCo())){
				
				%>
					<input class="idx" type="text" value="<%=supple.getIdx()%>" readonly="on"><input class="price" id="sPrice" type="text" value="<%=supple.getPrice()%>"><input class="price" id="sCnt" type="text" value="<%=supple.getCnt()%>"><br><br>
					<input class="pname" id="sName" type="text" value="<%=supple.getName()%>"><br><br>
					<textarea id="sInfo" class="pcontent"><%=supple.getInfo()%></textarea>
					<div class="btn-area">
					<input class="pbtn" onclick="SDelete('<%=supple.getIdx() %>')" type="button" value="삭제">	<input class="pbtn" onclick="SUpdate('<%=supple.getIdx() %>')" type="button" value="수정">	<input class="pbtn" onclick="window.close()" type="button" value="닫기">
				<%
			}else{
				%>
					<input class="idx" type="text" value="<%=supple.getIdx()%>" readonly="readonly"><input class="price" type="text" placeholder="요청 개수"><br><br>
					<input class="pname" type="text" readonly="readonly" value="<%=supple.getName()%>"><br><br>
					<textarea class="pcontent" readonly="readonly"><%=supple.getInfo()%></textarea>
					<div class="btn-area">
					<input class="pbtn" type="button" value="요청">	<input class="pbtn" onclick="window.close()" type="button" value="닫기">
				<%
			}
		%>
			
		</div>

	</div>
	
</body>
</html>