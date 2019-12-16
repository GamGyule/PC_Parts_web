<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.pc.parts.dto.SuppleDTO, com.pc.parts.dto.NotiDTO"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<script src="<%=request.getContextPath()%>/js/sort.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@0.7.0"></script>
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


</style>

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
				<a href="./supple"><li>재고 관리</li></a>
				<a href="./log"><li>입·출고 관리</li></a>
				<a href="./chart"><li class="tab-select">통계 관리</li></a>
				<a href="./noti"><li>재고 요청</li></a>
			</ul>
		</div>
		<div style="overflow: hidden;padding-left: 10px;">
			<p>회사</p>
			<select onchange="reqChart(this)">
			<option selected>선택</option>
			<option>AAAA</option>
			<option>BBBB</option>
			</select>
			<div id="chartMain" style="width:800px;">
				<canvas id="myChart"></canvas>
			</div>
		</div>
		<script>
		function reqChart(my){
			var chart = new Vue({
				el:"#chartMain",
				data:{
					label:""
				},
				methods:{
					getData:function(){
						var vm = this;
						axios.get("/getChart?co="+my.value)
						.then(res=>{
							vm.viewChart(res.data);
						}).catch(err=>{
							console.log(err);
						})
					},
					viewChart:function(data){
						var pdCnt = new Array();
						var pdName = new Array();
						for(var i in data){
							pdCnt.push(data[i].cnt);
							pdName.push(data[i].name + "(" + data[i].pid + ")");
						}
						var ctx = document.getElementById('myChart').getContext('2d');
						var myPieChart = new Chart(ctx, {
						    type: 'pie',
						    data: {
						    	labels: pdName,
						    	datasets: [{
						        	data: pdCnt,
						        	backgroundColor: poolColors(pdCnt.length)
						    	}]},
						    options:{
						    	plugins:{
							    	datalabels:{
							            font: {
							              size: 30
							            }
							    	}
							    }
						    }
						});
					}
				},
				mounted:function(){
			        this.$nextTick(function() {
			        	this.getData();
			        })
				}
			})
		}
		function dynamicColors() {
		    var r = Math.floor(Math.random() * 255);
		    var g = Math.floor(Math.random() * 255);
		    var b = Math.floor(Math.random() * 255);
		    return "rgba(" + r + "," + g + "," + b + ", 0.5)";
		}
		function poolColors(a) {
		    var pool = [];
		    for(i = 0; i < a; i++) {
		        pool.push(dynamicColors());
		    }
		    return pool;
		}
		</script>
	</div>
	</body>
</html>