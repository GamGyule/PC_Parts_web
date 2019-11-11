<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.pc.parts.dto.SuppleDTO, com.pc.parts.dto.NotiDTO"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<script src="<%=request.getContextPath()%>/js/sort.js"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Roboto&display=swap" rel="stylesheet">
<style>
html, body {
	font-family: 'Nanum Gothic', sans-serif;
	font-family: 'Roboto', sans-serif;
	font-size: 18px;
	overflow: hidden;
}

a {
	text-decoration: none;
	color: black;
}

li {
	height: 50px;
	line-height: 50px;
	width: 210px;
	text-align: center;
	line-height: 50px;
}

.tab-select {
	background-color: #fdcb6e;
}

li:hover {
	cursor: pointer;
	background-color: #fcdb9d;
}

.frame {
	width: 110px;
	margin: 0 auto;
	margin-right: 10px;
	display: inline-block;
	position: relative;
	cursor: pointer;
	float: left;
	top: 20px;
	left: 15px;
}

.frame:hover .hex-inner {
	height: 100px;
	top: 90px !important;
	border-radius: 4px;
}

.frame:hover .label {
	transform: scale(.95);
	-webkit-transform: scale(.95);
}

.hex-outer {
	background: #fdcb6e;
	width: 110px;
	height: 64px;
}

.h1 {
	position: absolute;
}

.h2 {
	position: absolute;
	transform: rotate(60deg);
	-webkit-transform: rotate(60deg);
}

.h3 {
	position: absolute;
	transform: rotate(-60deg);
	-webkit-transform: rotate(-60deg);
}

.label {
	position: relative;
	color: white;
	font-weight: bold;
	text-align: center;
	left: 0px;
	transition: all .1s;
	-webkit-transition: all .1s;
}

.frame:hover .noti-cnt {
	text-decoration: underline !important;
}

.frame:hover .noti-cnt {
	text-decoration: underline !important;
}

.noti-cnt {
	font-size: 24px;
}

.noti-area {
	position: absolute;
}

.h2c-bar {
	border: 2px solid #f39c12;
	margin: 0px;
}

.product-list {
	margin-left: 10px;
	display: inline-block;
	float: left;
}

.product_table {
	padding: 0px;
	border-collapse: collapse;
}

.product_table th {
	background-color: #fdcb6e;
}

.product_table th:hover {
	user-select: none;
	cursor: pointer;
	background-color: #fcdb9d;
}

.product_table td {
	padding: 5px;
}

.product_table td div {
	width: 450px;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

.product_table th:nth-child(6) {
	width: 100px;
	min-width: 100px;
}

.product_table th:nth-child(7) {
	width: 50px;
	min-width: 50px;
}

.product_table th:nth-child(1) {
	min-width: 150px;
}

.product_table th:nth-child(2) {
	min-width: 100px;
}

.product_table th:nth-child(3) {
	min-width: 100px;
}

.product_table th:nth-child(4) {
	width: 450px;
    min-width: 450px;
}

.product_table th:nth-child(5) {
	min-width: 100px;
}

.product_table td:nth-child(2) {
	text-align: center;
}
.product_table td:nth-child(3) {
	text-align: center;
}
.product_table td:nth-child(4) {
	text-align: left;
}

.product_table td:nth-child(5) {
	text-align: right;
}

.product_table td:nth-child(6) {
	text-align: center;
}

.search-box {
	padding: 5px;
	margin-top: 80px;
	float: left;
	width: 280px;
	height: 500px;
	border: 1px solid black;
	border-radius: 7px;
	margin-left: 10px;
}

.search-box-input {
	width: 96%;
	height: 30px;
	padding: 3px;
	margin-bottom: 3px;
}

.supple-tr:hover {
	background-color: #eeeeee;
	cursor: pointer;
}

.current-page {
	color: red;
}

.under-count {
	background-color: #fab7af;
}

.list-number {
	display: inline-block;
	text-align: center;
	line-height: 20px;
	width: 20px;
	height: 20px;
	border: 1px solid black;
	border-radius: 3px;
}

.search-box-btn {
	width: 100%;
	height: 40px;
	background-color: #FDCB6E;
	border: 0px;
	outline: none;	
}
.search-box-btn:hover{
	cursor: pointer;
	background-color: #fcdb9d;
}

.noti-btn{
	width:80px;
}

.isCmt{
	background-color: #fab7af;
}

</style>
<script>
	function flagupdate(idx){
		var myForm = document.flagUpdate;
		myForm.method = "post";
	}
	
	function SupRequestPage(idx){
		var myForm = document.supRequestPage;
		myForm.supIdx.value = idx;
		var url = "/supRequestPage";
		myForm.action = url;
		myForm.method="post";
		window.open("","popForm","width=420,height=600,left=700,top=150,resizable=no,menubar=no");
		myForm.target = "popForm";
		myForm.submit();
	}
	
</script>

<meta charset="UTF-8">
<title>관리하자</title>
</head>
<form name="supRequestPage">
	<input type="hidden" name="supIdx">
</form>

<body style="margin: 0; padding: 0;">
	<%
	List<NotiDTO> noti_listAll = null;
	ArrayList<String> Noti_name = null;
	ArrayList<Integer> cmtList = null;
	if (request.getAttribute("noti_listAll") != null) {
		noti_listAll = (List<NotiDTO>) request.getAttribute("noti_listAll");
	}
	
	if (request.getAttribute("noti_nameList") != null) {
		Noti_name = (ArrayList<String>) request.getAttribute("noti_nameList");
	}
	
	if(request.getAttribute("notiCmtCount") != null){
		cmtList = (ArrayList<Integer>)request.getAttribute("notiCmtCount");
	}
	
	%>
	<div style="height: 100px;color:white; line-height: 100px; width: 100%;padding:0 10px 0 10px;box-sizing: border-box;font-size: 32px;background-color:#fdcb6e;">
		<img width="50" src="images/admin_icon.png"/><span>PC_Parts 관리자</span>
	</div>
<!-- 	<hr class="h2c-bar"> -->
	<div class="container" style="display: inline-block;width:100%;">
		<div style="float: left; height: 100%; display: inline-block;">
			<ul style="list-style: none; padding: 0px; margin: 0px;; height: 1200px;">
				<a href="./home"><li>홈</li></a>
				<a href="./supple"><li>재고 관리</li></a>
				<a href="javascript:;"><li>입·출고 관리</li></a>
				<a href="javascript:;"><li>통계 관리</li></a>
				<a href="./noti"><li class="tab-select">재고 요청</li></a>
			</ul>
		</div>

		<div style="overflow: hidden;">
		<div class="product-list">
			<div style="margin-left: 5px;display: inline-block;"><h2>요청 리스트</h2></div>
			<br>
			<div style="display: inline-block;min-height: 727px;">
				<table id="indexTable" class="product_table" style="table-layout: fixed;">
					<thead>
						<th onClick="SortTable(0,'T');">날짜</th><th onClick="SortTable(1,'T');">요청한 회사</th><th onclick="SortTable(2,'T');">상품 번호</th><th onclick="SortTable(3,'T');">상품 이름</th><th onclick="SortTable(4,'N');">요청 개수</th><th>처리 현황</th><th>비고</th>
					</thead>
					<tbody>
					<%
					for(int i = 0; i < noti_listAll.size(); i++) {
						NotiDTO noti = noti_listAll.get(i);
						if(noti.getTo_co().equals(request.getAttribute("user"))){
							if(noti.getFlag() == 0){
								%>
									<form  action="./updateaction">
										<input type="hidden" name="flagUpdate" value="<%=noti.getIdx()%>">
										<tr onclick="SupRequestPage('<%=noti.getIdx()%>')" class="supple-tr <%=((cmtList.get(i) > 0)?"isCmt":"")%>"><td><%=noti.getDate() %></td><td><%=noti.getFrom_co() %></td><td><%=noti.getPid() %></td><td><div title="<%=Noti_name.get(i).toString()%>"><%=Noti_name.get(i).toString()%></div></td><td><%=noti.getCnt() %></td><td>대기중</td><td><button class="noti-btn" onclick="('<%=noti.getIdx()%>')">수락</button></td></tr>
									</form>
								<%
							}else if(noti.getFlag()==2){
								%>
									<tr onclick="SupRequestPage('<%=noti.getIdx()%>')" class="supple-tr <%=((cmtList.get(i) > 0)?"isCmt":"")%>"><td><%=noti.getDate() %></td><td><%=noti.getFrom_co() %></td><td></td><td><%=noti.getPid() %></td><td><div title="<%=Noti_name.get(i).toString()%>"><%=Noti_name.get(i).toString()%></div></td><td><%=noti.getCnt() %></td><td>취소됨</td><td>-</td></tr>
							
							<%
						}
							else{
								%>
									<tr onclick="SupRequestPage('<%=noti.getIdx()%>')" class="supple-tr <%=((cmtList.get(i) > 0)?"isCmt":"")%>"><td><%=noti.getDate() %></td><td><%=noti.getFrom_co() %></td><td><%=noti.getPid() %></td><td><div title="<%=Noti_name.get(i).toString()%>"><%=Noti_name.get(i).toString()%></div></td><td><%=noti.getCnt() %></td><td>완료</td><td>-</td></tr>
								<%
							}
						}else if(noti.getFrom_co().equals(request.getAttribute("user"))){
							if(noti.getFlag() == 0){
								%>
									<form  action="./updateaction">
									<input type="hidden" name="flagUpdate2" value="<%=noti.getIdx()%>">
									<tr onclick="SupRequestPage('<%=noti.getIdx()%>')" class="supple-tr <%=((cmtList.get(i) > 0)?"isCmt":"")%>"><td><%=noti.getDate() %></td><td><%=noti.getFrom_co() %></td><td><%=noti.getPid() %></td><td><div title="<%=Noti_name.get(i).toString()%>"><%=Noti_name.get(i).toString()%></div></td><td><%=noti.getCnt() %></td><td>대기중</td><td><button class="noti-btn" onclick="('<%=noti.getIdx()%>')">취소</button></td></tr>
									
									</form>
								<%
							}else if(noti.getFlag() == 2){
								%>
								<tr onclick="SupRequestPage('<%=noti.getIdx()%>')" class="supple-tr <%=((cmtList.get(i) > 0)?"isCmt":"")%>"><td><%=noti.getDate() %></td><td><%=noti.getFrom_co() %></td><td><%=noti.getPid() %></td><td><div title="<%=Noti_name.get(i).toString()%>"><%=Noti_name.get(i).toString()%></div></td><td><%=noti.getCnt() %></td><td>취소됨</td><td>-</td></tr>
							
							<%
						}
							else{
								%>
									<tr onclick="SupRequestPage('<%=noti.getIdx()%>')" class="supple-tr <%=((cmtList.get(i) > 0)?"isCmt":"")%>"><td><%=noti.getDate() %></td><td><%=noti.getFrom_co() %></td><td><%=noti.getPid() %></td><td><div title="<%=Noti_name.get(i).toString()%>"><%=Noti_name.get(i).toString()%></div></td><td><%=noti.getCnt() %></td><td>완료</td><td>-</td></tr>
								
								<%
							}
						}
					}
					
					%>
<!-- 						<tr class="supple-tr"><td>2019-10-21 11:10</td><td>AAAA01</td><td>AAAA01의 상품 이름</td><td>21</td><td>완료</td><td>-</td></tr></td><td><input class="noti-btn" type="button" value="취소">
						<tr class="supple-tr"><td>2019-10-21 11:27</td><td>AAAA01</td><td>AAAA01의 상품 이름</td><td>21</td><td>대기중</td><td><input class="noti-btn" type="button" value="수락"></td></tr>
						<tr class="supple-tr"><td>2019-10-21 11:28</td><td>AAAA01</td><td>AAAA01의 상품 이름</td><td>21</td><td>대기중</td><td><input class="noti-btn" type="button" value="수락"></td></tr>
						<tr class="supple-tr"><td>2019-10-21 11:29</td><td>AAAA01</td><td>AAAA01의 상품 이름</td><td>21</td><td>대기중</td><td><input class="noti-btn" type="button" value="취소"></td></tr>
						<tr class="supple-tr"><td>2019-10-21 11:30</td><td>AAAA01</td><td>AAAA01의 상품 이름</td><td>21</td><td>대기중</td><td><input class="noti-btn" type="button" value="수락"></td></tr> -->
					</tbody>
				</table>
			</div>
			
		</div>
		</div>
	</div>
	</body>
</html>