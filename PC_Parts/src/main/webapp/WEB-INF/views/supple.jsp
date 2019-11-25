<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.pc.parts.dto.SuppleDTO,java.util.List"%>
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
	min-width: 100px;
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
	width: 450px;
	min-width: 450px;
}

.product_table td:nth-child(3) {
	text-align: center;
}

.product_table td:nth-child(6) {
	text-align: right;
}

.product_table td:nth-child(7) {
	text-align: right;
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

</style>
<script>
	function smodifySubmit(idx){
		var myForm = document.popForm;
		var url = "/smodify";
		window.open("","popForm","width=420,height=430,left=700,top=150,resizable=no,menubar=no");
		myForm.action = url;
		myForm.method = "post";
		myForm.target = "popForm";
		myForm.suppleIdx.value = idx;
		myForm.submit();
	}
</script>
<meta charset="UTF-8">
<title>관리하자</title>
</head>
<body style="margin: 0; padding: 0;">
	<div style="height: 100px;color:white; line-height: 100px; width: 100%;padding:0 10px 0 10px;box-sizing: border-box;font-size: 32px;background-color:#fdcb6e;">
		<img width="50" src="images/admin_icon.png"/><span>PC_Parts 관리자</span>
	</div>
<!-- 	<hr class="h2c-bar"> -->
	<div class="container" style="display: inline-block;width:100%;">
		<div style="float: left; height: 100%; display: inline-block;">
			<ul style="list-style: none; padding: 0px; margin: 0px;; height: 1200px;">
				<a href="./home"><li>홈</li></a>
				<a href="./supple"><li class="tab-select">재고 관리</li></a>
				<a href="javascript:;"><li>입·출고 관리</li></a>
				<a href="./chart"><li>통계 관리</li></a>
				<a href="./noti"><li>재고 요청</li></a>
			</ul>
		</div>
		<form name="popForm">
			<input type="hidden" name="cmd" value="openPop">
			<input type="hidden" name="suppleIdx">
		</form>
		<div style="overflow: hidden;">
		<div class="product-list">
			<div style="margin-left: 5px;display: inline-block;"><h2>제품 관리</h2></div>
			<br>
			<div style="display: inline-block;min-height: 727px;">
				<table id="indexTable" class="product_table" style="table-layout: fixed;">
					<thead>
						<th onClick="SortTable(0,'T');">번호</th><th onclick="SortTable(1,'T');">회사</th><th onclick="SortTable(2,'N');">부품</th><th onclick="SortTable(3,'T');">제품 이름</th><th onclick="SortTable(4,'T');">제품 설명</th><th onclick="SortTable(5,'N');">가격</th><th onclick="SortTable(6,'N');">개수</th>
					</thead>
					<tbody>
					<%
						if(request.getAttribute("list") != null){
							List<SuppleDTO> list = (List<SuppleDTO>)request.getAttribute("list");
							for(int i = 0; i < list.size();i++){
								SuppleDTO supple = list.get(i);
								if(supple.getCnt() > 5){
									%>
										<tr onclick="smodifySubmit('<%=supple.getIdx() %>')" class="supple-tr">
											<td><%=supple.getIdx() %></td><td><%=supple.getCo() %></td><td><%=supple.getPid() %></td><td title="<%=supple.getName()%>"><div><%=supple.getName()%></div></td><td><div title="<%=supple.getInfo()%>"><%=supple.getInfo()%></div></td><td><%=String.format("%,d",supple.getPrice()) %></td><td><%=String.format("%,d",supple.getCnt()) %></td>
										</tr>
									<%
								}else{
									%>
									<tr onclick="smodifySubmit('<%=supple.getIdx() %>')" class="supple-tr under-count">
										<td><%=supple.getIdx() %></td><td><%=supple.getCo() %></td><td><%=supple.getPid() %></td><td title="<%=supple.getName()%>"><div><%=supple.getName()%></div></td><td><div title="<%=supple.getInfo()%>"><%=supple.getInfo()%></div></td><td><%=String.format("%,d",supple.getPrice()) %></td><td><%=String.format("%,d",supple.getCnt()) %></td>
									</tr>
								<%
								}
							}
						}
					%>
					</tbody>
				</table>
			</div>
			<div style="text-align: center">
					<%
						int suppleCount = 0;
						String searchName = "";
						String searchCompany = "";
						int currentPage = 1;
						
						String url = "./supple?";
						
						if(request.getAttribute("SuppleCnt") != null){
							suppleCount = (Integer)request.getAttribute("SuppleCnt");
						}
						
						if(request.getParameter("searchName") != null){
							searchName = request.getParameter("searchName");
							url += "searchName"+"="+searchName+"&";
						}
						
						if(request.getParameter("searchCompany") != null){
							searchCompany = request.getParameter("searchCompany");
							url += "searchCompany"+"="+searchCompany+"&";
						}
						
						if(request.getParameter("page") != null){
							currentPage = Integer.parseInt(request.getParameter("page"));
						}
						
						
						if(currentPage >= 4){
							%>
								<a class="list-number" href="<%=url %>page=1">1</a>...
							<%
						}
						
						if(suppleCount % 20 == 0){
							for(int i = 1; i <= suppleCount/20;i++){
								%>
									<a class="list-number" href="<%=url %>page=<%=i%>"> <%=i%></a>
								<%
							}
						}else{
							for(int i = 1; i <= suppleCount/20+1;i++){
								if(Math.abs(currentPage-i) <= 2){
									if(currentPage == i){
										%>
											<a class="list-number current-page" href="<%=url %>page=<%=i%>"> <%=i%></a>
										<%
									}else{
										%>
											<a class="list-number" href="<%=url %>page=<%=i%>"> <%=i%></a>
										<%
									}
									
								}
							}
							if((suppleCount/20+1 - currentPage) >= 3){
								%>...<a class="list-number" href="<%=url %>page=<%=suppleCount/20+1 %>"><%=suppleCount/20+1 %></a><%
							}
						}
						
					%>
				</div>
		</div>
		<div style="overflow: hidden;">
			<div class="search-box">
				<h3>상세 검색</h3>
				<form action="./supple" method="get">
					<input name ="searchName" class="search-box-input" type="text" placeholder="이름 검색) INTEL" value="<%=searchName%>">
					<input name = "searchCompany" class="search-box-input" type="text" placeholder="회사 검색) AAAA" value="<%=searchCompany%>">
					<input class="search-box-btn" type="submit" value="검색하기">
				</form>
				<form name="excelForm" enctype="multipart/form-data">
					<p>Excel 파일 추가</p><input name="files" type="file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" onchange="excelImport(this)"/>
				</form>
				
				<script>
					function excelImport(t){
						var myForm = document.excelForm;
						myForm.action = "/importExcel";
						myForm.method = "post";
						
						var fileExt = t.value.substring(t.value.lastIndexOf('.')+1,t.value.length);
						
						fileExt = fileExt.toLowerCase();
						
						if(fileExt == "xls" || fileExt == "xlsx"){
							myForm.submit();
							return true;
						}else if(fileExt == ""){
							return false;
						}else{
							alert("엑셀 파일이 아닙니다.");
							return false;
						}
					}
				</script>
			</div>
		</div>
		</div>
	</div>
	</body>
</html>