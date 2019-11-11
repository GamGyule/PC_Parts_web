<%@page import="com.pc.parts.dto.CompanyDTO"%>
<%@page import="com.pc.parts.dto.NotiDTO, java.util.List,com.pc.parts.dto.NotiCmtDTO"%>
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
.noti-name{
	width: 254px;
	height:25px;
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

.from-co{
width:calc(50% - 50px);
height:25px;
}

.to-co{
width:calc(50% - 50px);
height:25px;
}

.cmt-mine{
	text-align: right;
	display: block;
}

.cmt-other{
	text-align: left;
	display: block;
}

.text-box{
	background-color: RGBA(255,255,255,1);
	min-width:100px;
	max-width:200px;
	display: inline-block;
	border-radius: 3px;
	padding:7px;
}

.cmt-submit{
	width:100px;
}

.cmt-content{
	width:250px;
}
</style>
<script>

</script>
</head>
<body>
<%
	NotiDTO notiDto = null;
	List<NotiCmtDTO> notiCmtList = (List<NotiCmtDTO>)request.getAttribute("notiCmtList");
	
	if(request.getAttribute("notiInfo") != null){
		notiDto = (NotiDTO)request.getAttribute("notiInfo");
	}
	CompanyDTO user = (CompanyDTO)session.getAttribute("user");
%>
	<div class="input-area">
		<input class="idx" type="text" value="<%=notiDto.getIdx()%>" readonly="readonly"><input class="noti-name" type="text" value="<%=request.getAttribute("notiName")%>">
		<input class="from-co" type="text" readonly="readonly" value="<%=notiDto.getFrom_co()%>"><span> >> </span><input class="to-co" type="text" readonly="readonly" value="<%=notiDto.getTo_co()%>"><br><br>		
		
		<div class="btn-area">
			<form name="SRequestForm">
				<input type="hidden" name="notiIdx" value="<%=notiDto.getIdx()%>">
				<input type="hidden" name="myComp" value="<%=user.getCo()%>">
				<div id="textArea" style="width:100%; border:1px solid black; background-color:RGBA(0,0,0,0.1); height:300px;overflow-y:auto;">
				
				<%
					for(NotiCmtDTO cmt : notiCmtList){
						if(cmt.getCmt_comp().equals(user.getCo())){
							%>
								<div class="cmt-mine"><span><%=cmt.getCmt_comp() %></span><br><span class="text-box"><%=cmt.getCmt_content() %></span><br><span><%=cmt.getDate().toLocaleString() %></span></div>
							<%
						}else{
							%>
								<div class="cmt-other"><span><%=cmt.getCmt_comp() %></span><br><span class="text-box"><%=cmt.getCmt_content() %></span><br><span><%=cmt.getDate().toLocaleString() %></span></div>
							<%
						}
					}
				%>
				</div>
				<input type="text" name="notiCmtContent" placeholder="내용" class="cmt-content">
				<input type="button" onclick="SendReply()" class="cmt-submit" value="등록하기">
			</form>
		<script>
		var textArea = document.querySelector("#textArea");
		textArea.scrollTop = textArea.scrollHeight;
		
			function SendReply(){
				var myForm = document.SRequestForm;
				var content = myForm.notiCmtContent.value;
				
				if(content == ""){
					alert("댓글을 입력해주세요!");
					return;
				}
				var url = "/sendReply";
				myForm.action = url;
				myForm.method = "post";
				myForm.submit();
				
				location.reload();
				
			}
		</script>
		<input class="pbtn" onclick="window.close()" type="button" value="닫기">
		</div>
	</div>
</body>
</html>