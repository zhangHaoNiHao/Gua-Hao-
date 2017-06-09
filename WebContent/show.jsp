<%@ page language="java" import="text.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排队情况</title>
</head>
<script type="text/javascript">
	var k;
	var g;
	function p1(){
		var keshi = document.getElementsByName('keshi');
		for(var i = 0;i < keshi.length;i++){
			if(keshi[i].checked == true){				
				k = i;
			}
		}
	
		var type = document.getElementsByName('type');
		for(var i = 0;i < type.length;i++){
			if(type[i].checked == true){					
				g = i;
			}				
		}
	
		var d = "doc" + k + g;
		document.getElementById('doc00').style.display='none';
		document.getElementById('doc01').style.display='none';
		document.getElementById('doc10').style.display='none';
		document.getElementById('doc11').style.display='none';
		document.getElementById('doc20').style.display='none';
		document.getElementById('doc21').style.display='none';
		document.getElementById('doc30').style.display='none';
		document.getElementById('doc31').style.display='none';
		document.getElementById(d).style.display='block';
		return d;
	}
</script>
<body onload = "p1()">
<center>	
	<h3>请选择科室</h3>
	<input type="radio" value="1" name="keshi" checked="checked" onclick="p1()">外科</td>
	<input type="radio" value="2" name="keshi" onclick="p1()">内科</td>
	<input type="radio" value="3" name="keshi" onclick="p1()">儿科</td>
	<input type="radio" value="4" name="keshi" onclick="p1()">眼科</td>
	<h3>请选择挂号类型</h3>
	<input type="radio" value="putong" name="type" checked="checked" onclick="p1()">普通号</td>
	<input type="radio" value="vip" name="type" onclick="p1()">专家号</td>
	<h3>排队情况</h1>
	
	<div id="doc00">
		<table>
			<tr>
				<td>普通外科医生A的队列</td> 
			</tr>
			<tr><td>
			<%
			if(Jiuzhen.queuePWaiA.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePWaiA %>
				<%
			}
			%></td></tr>
			<tr>
				<td>普通外科医生B的队列</td>
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePWaiB.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePWaiB %>
				<%
			}
			%></td></tr>
			<tr>
				<td>普通外科医生C的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePWaiC.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePWaiC %>
				<%
			}
			%></td></tr>
		</table>
	</div>
   <div id="doc01">
		<table>
			<tr>
				<td>专家外科医生A的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVWaiA.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVWaiA %>
				<%
			}
			%></td></tr>
			<tr>
				<td>专家外科医生B的队列</td>
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVWaiB.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVWaiB %>
				<%
			}
			%></td></tr>
			<tr>
				<td>专家外科医生C的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVWaiC.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVWaiC %>
				<%
			}
			%></td></tr>
		</table>
	</div>
	<div id="doc10">
		<table>
			<tr>
				<td>普通内科医生A的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePNeiA.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePNeiA %>
				<%
			}
			%></td></tr>
			<tr>
				<td>普通内科医生B的队列</td>
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePNeiB.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePNeiB %>
				<%
			}
			%></td></tr>
			<tr>
				<td>普通内科医生C的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePNeiC.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePNeiC %>
				<%
			}
			%></td></tr>
		</table>
	</div>
   <div id="doc11">
		<table>
			<tr>
				<td>专家内科医生A的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVNeiA.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVNeiA %>
				<%
			}
			%></td></tr>
			<tr>
				<td>专家内科医生B的队列</td>
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVNeiB.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVNeiB %>
				<%
			}
			%></td></tr>
			<tr>
				<td>专家内科医生C的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVNeiC.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVNeiC %>
				<%
			}
			%></td></tr>
		</table>
	</div>
	<div id="doc20">
		<table>
			<tr>
				<td>普通儿科医生A的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePErA.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePErA %>
				<%
			}
			%></td></tr>
			<tr>
				<td>普通儿科医生B的队列</td>
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePErB.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePErB %>
				<%
			}
			%></td></tr>
			<tr>
				<td>普通儿科医生C的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePErC.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePErC %>
				<%
			}
			%></td></tr>
		</table>
	</div>
   <div id="doc21">
		<table>
			<tr>
				<td>专家儿科医生A的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVErA.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVErA %>
				<%
			}
			%></td></tr>
			<tr>
				<td>专家儿科医生B的队列</td>
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVErB.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVErB %>
				<%
			}
			%></td></tr>
			<tr>
				<td>专家儿科医生C的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVErC.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVErC %>
				<%
			}
			%></td></tr>
		</table>
	</div>
	<div id="doc30">
		<table>
			<tr>
				<td>普通眼科医生A的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePYanA.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePYanA %>
				<%
			}
			%></td></tr>
			<tr>
				<td>普通眼科医生B的队列</td>
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePYanB.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePYanB %>
				<%
			}
			%></td></tr>
			<tr>
				<td>普通眼科医生C的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queuePYanC.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queuePYanC %>
				<%
			}
			%></td></tr>
		</table>
	</div>
   <div id="doc31">
		<table>
			<tr>
				<td>专家眼科医生A的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVYanA.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVYanA %>
				<%
			}
			%></td></tr>
			<tr>
				<td>专家眼科医生B的队列</td>
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVYanB.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVYanB %>
				<%
			}
			%></td></tr>
			<tr>
				<td>专家眼科医生C的队列</td> 
			</tr>
			<tr><td><%
			if(Jiuzhen.queueVYanC.peek() == null)
			{
				%><h4>空</h4><%
			}
			else{
				%><%=Jiuzhen.queueVYanC %>
				<%
			}
			%></td></tr>
		</table>
	</div>
	
</center>

</body>
</html>