<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>就诊</title>
</head>
<script type="text/javascript">
	function p1(){
		var k;
		var jiuzhen = document.getElementsByName('jiuzhen');
		for(var i = 0;i < jiuzhen.length;i++){
			if(jiuzhen[i].checked == true)
				k = i;
		}
		document.getElementById('0').style.display='none';
		document.getElementById('1').style.display='none';
		document.getElementById('2').style.display='none';
		document.getElementById('3').style.display='none';
		document.getElementById('4').style.display='none';
		document.getElementById('5').style.display='none';
		document.getElementById('6').style.display='none';
		document.getElementById(k).style.display='block';
		
	}
</script>
<body onload="p1()">
<center>
	<h1>就诊</h1>
	<hr>
	<form action="jiuzhen2" method="post">
	<h5>请选择科室</h5>
	<input type="radio" name="jiuzhen" value="1" checked="checked" onclick="p1()"/>外科就诊
	<br>
	<input type="radio" name="jiuzhen" value="2" onclick="p1()"/>内科就诊
	<br>
	<input type="radio" name="jiuzhen" value="3" onclick="p1()"/>儿科就诊
	<br>
	<input type="radio" name="jiuzhen" value="4" onclick="p1()"/>眼科就诊
	<br>
	<input type="radio" name="jiuzhen" value="5" onclick="p1()"/>换药室就诊
	<br>
	<input type="radio" name="jiuzhen" value="6" onclick="p1()"/>放射科就诊
	<br>
	<input type="radio" name="jiuzhen" value="7" onclick="p1()"/>口腔科就诊
	<br>
	<h5>请选择医生</h5>
	<div id="0" class="xianshi">
	<table>
		<tr>
			<td><input type="radio" name="Wai" value="PWaiA" checked="checked"/>普通外科医生A</td>
			<td><input type="radio" name="Wai" value="PWaiB" />普通外科医生B</td>
			<td><input type="radio" name="Wai" value="PWaiC" />普通外科医生C</td>
		</tr>
		</tr>
			<td><input type="radio" name="Wai" value="VWaiA" />专家外科医生A</td>
			<td><input type="radio" name="Wai" value="VWaiB" />专家外科医生B</td>
			<td><input type="radio" name="Wai" value="VWaiC" />专家外科医生C</td>
		</tr>
	</table>
	</div>
	<div id="1" class="xianshi">
	<table>
		<tr>
			<td><input type="radio" name="Nei" value="PNeiA" checked="checked"/>普通内科医生A</td>
			<td><input type="radio" name="Nei" value="PNeiB" />普通内科医生B</td>
			<td><input type="radio" name="PNei" value="PNeiC" />普通内科医生C</td>
		</tr>
		<tr>
			<td><input type="radio" name="Nei" value="VNeiA" />专家内科医生A</td>
			<td><input type="radio" name="Nei" value="VNeiB" />专家内科医生B</td>
			<td><input type="radio" name="Nei" value="VNeiC" />专家内科医生C</td>
		</tr>
	</table>
	</div>
	<div id="2" class="xianshi">
	<table>
		<tr>
			<td><input type="radio" name="Er" value="PErA" checked="checked"/>普通儿科医生A</td>
			<td><input type="radio" name="Er" value="PErA" />普通儿科医生B</td>
			<td><input type="radio" name="PEr" value="PErA" />普通儿科医生C</td>
		</tr>
		<tr>
			<td><input type="radio" name="Er" value="VErA" />专家儿科医生A</td>
			<td><input type="radio" name="Er" value="VErB" />专家儿科医生B</td>
			<td><input type="radio" name="Er" value="VErC" />专家儿科医生C</td>
		</tr>
	</table>
	</div>
	<div id="3" class="xianshi">
	<table>
		<tr>
			<td><input type="radio" name="Yan" value="PYanA" checked="checked"/>普通眼科医生A</td>
			<td><input type="radio" name="Yan" value="PYanA" />普通眼科医生B</td>
			<td><input type="radio" name="Yan" value="PYanA" />普通眼科医生C</td>
		</tr>
		<tr>
			<td><input type="radio" name="Yan" value="VYanA" />专家眼科医生A</td>
			<td><input type="radio" name="Yan" value="VYanB" />专家眼科医生B</td>
			<td><input type="radio" name="Yan" value="VYanC" />专家眼科医生C</td>
		</tr>
	</table>
	</div>
	<div id="4" class="xianshi">
	<table>
		<tr>
			<td><input type="radio" name="Huan" value="PHuanA" checked="checked"/>普通换药护士A</td>
			<td><input type="radio" name="Huan" value="VHuanA" />专家换药护士A</td>
		</tr>
	</table>
	</div>
	<div id="5" class="xianshi">
	<table>
		<tr>
			<td><input type="radio" name="Fang" value="PFang" checked="checked"/>普通放射科医生A</td>
			<td><input type="radio" name="Fang" value="VFang" />专家放射科医生A</td>
		</tr>
	</table>
	</div>
	<div id="6" class="xianshi">
	<table>
		<tr>
			<td><input type="radio" name="Kou" value="PKou" checked="checked"/>普通口腔医生A</td>
			<td><input type="radio" name="Kou" value="VKou" />专家口腔医生A</td>
		</tr>
	</table>
	</div>
	<br>
	<div>
		<table>
		   <tr><td>病人是否到达</td><tr>
		   <tr>
		   	   <td><input type="radio" name="arrive" value="病人到达" checked="checked"/>病人到达</td>
		   	   <td><input type="radio" name="arrive" value="病人未到" />病人未到</td>
		   </tr>
		</table>
	</div>
	<br>
	<input type="submit" value="就诊"> 
	</form>
</center>
</body>
</html>