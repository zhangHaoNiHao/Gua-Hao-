<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挂号</title>
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
			document.getElementById('doc40').style.display='none';
			document.getElementById('doc41').style.display='none';
			document.getElementById('doc50').style.display='none';
			document.getElementById('doc51').style.display='none';
			document.getElementById('doc60').style.display='none';
			document.getElementById('doc61').style.display='none';
			document.getElementById('doc70').style.display='none';
			document.getElementById('doc71').style.display='none';
			document.getElementById('doc80').style.display='none';
			document.getElementById('doc81').style.display='none';
			document.getElementById(d).style.display='block';
			return d;
		}
		function BingNumber(){	
			var date = new Date();
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			if(m<10)
				m = "0"+m;
			var d = date.getDate();
			if(d<10)
				d = "0"+d;
			
			var ke,ty,doctor;
			var keshi = document.getElementsByName('keshi');
			for(var i = 0;i < keshi.length;i++){
				if(keshi[i].checked == true){				
					ke = i;
				}
			}
			if(ke == 0) ke = "W";
			else if (ke == 1) ke = "N";
			else if (ke == 2) ke = "E";
			else ke = "Y";
			
			
			var type = document.getElementsByName('type');
			for(var i = 0;i < type.length;i++){
				if(type[i].checked == true){					
					ty = i;
				}				
			}
			if(ty == 0) ty = "P";
			else ty = "V";
			
			//ke = 0外科，1内科，2儿科，3眼科
			//ty = 0普通号，1专家号
			
			var num = ""+y+m+d+ty+ke;
			//num = 20170604
			
			var numbe = document.getElementById('num');
			numbe.innerHTML=num;
			document.getElementById('numInput').value=num;
		}
</script>

<body onload="p1();BingNumber()">
					<%  
					  String num1="000";
					  int num=0;   //访问网页次数计数
				      if(application.getAttribute("number")==null){   //application为全局对象，适合保存网页访问次数
				    	  num=1;
				      	  num1 = "001";
				      }
				      else{
				    	  num=Integer.parseInt(application.getAttribute("number").toString());  //获取number属性的值，方便记录
				    	  if(num > 0 && num <= 9)
				    		  num1 = "00"+num;
				    	  else if(num >= 10 && num <= 99)
				    		  num1="0"+num;
				      }
					  
				      application.setAttribute("number",num); 
				      application.setAttribute("Strnumber",num1); 
				     %>
	<center>
		<form action="servlet" method="post" >
		<br><br><br><br>
			<table height="200" width = "600" >
				<tr>
					<td>病历号</td>
					<td> <span id="num" name="number"></span><input type="hidden" name="numInput" id="numInput"><%=application.getAttribute("Strnumber") %> </td>
				</tr>
				
				<tr>
					<td>请选择科室：</td>
				</tr>
				<tr>
					<td><input type="radio" value="1" name="keshi" checked="checked" onclick="p1();BingNumber()">外科</td>
					<td><input type="radio" value="2" name="keshi" onclick="p1();BingNumber()">内科</td>
					<td><input type="radio" value="3" name="keshi" onclick="p1();BingNumber()">口腔科</td>
					<td><input type="radio" value="4" name="keshi" onclick="p1();BingNumber()">理疗室</td>
				</tr>
				<tr>
					<td><input type="radio" value="4" name="keshi" onclick="p1();BingNumber()">放射科</td>
					<td><input type="radio" value="4" name="keshi" onclick="p1();BingNumber()">妇科</td>
					<td><input type="radio" value="4" name="keshi" onclick="p1();BingNumber()">五官科</td>
					<td><input type="radio" value="4" name="keshi" onclick="p1();BingNumber()">换药室</td>
					<td><input type="radio" value="4" name="keshi" onclick="p1();BingNumber()">化验室</td>
					
				</tr>
				<tr>
					<td>请选择挂号类型</td>
					<td><input type="radio" value="putong" name="type" checked="checked" onclick="p1();BingNumber()">普通号</td>
					<td><input type="radio" value="vip" name="type" onclick="p1();BingNumber()">专家号</td>
				</tr>
				
				<tr> 
					<td>请选择医生</td>
				</tr>
				</table>
				<div id="doc01" >	
				 <table>
				   <tr>
					<td><a href="doctor/vdocWaiA.jsp">专家外科医生A</a></td>
				   </tr>
				  </table>
				</div>
				
				<div id="doc00">	
				<table>
					<tr>
						<td><a href="doctor/pdocWaiA.jsp">普通外科医生A</a></td>
					</tr>
				</table>
				</div>
					
				<div id="doc11" class="doc">	
				<table>
					<tr>
						<td><a href="doctor/vdocNeiA.jsp">专家内科医生A</a></td>
					</tr>
				</table>
				</div>
				<div id="doc10" class="doc">	
				<table>
					<tr>
						<td><a href="doctor/pdocNeiA.jsp">普通内科医生A</a></td>
					</tr>
				</table>	
				</div>
				
				<div id="doc21" class="doc">	
				<table>
				<tr>
					<td><a href="doctor/vdocErA.jsp">专家口腔科医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc20" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocKouA" name="doc20" checked="checked"><a href="doctor/pdocErA.jsp">普通口腔科医生A</a></td>
				</tr>
				</table>
				</div>
				
				<div id="doc41" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocFangA" name="doc41" checked="checked"><a href="doctor/vdocYanA.jsp">专家放射科医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc40" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocFangA" name="doc40" checked="checked"><a href="doctor/pdocYanA.jsp">普通放射科医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc51" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocFuA" name="doc51" checked="checked"><a href="doctor/vdocYanA.jsp">专家妇科医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc50" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocFuA" name="doc50" checked="checked"><a href="doctor/pdocYanA.jsp">普通妇科医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc61" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocWuA" name="doc61" checked="checked"><a href="doctor/vdocYanA.jsp">专家五官科医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc60" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocWuA" name="doc60" checked="checked"><a href="doctor/pdocYanA.jsp">普通五官科医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc71" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocHuanA" name="doc61" checked="checked"><a href="doctor/vdocYanA.jsp">专家换药医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc70" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocHuanA" name="doc70" checked="checked"><a href="doctor/pdocYanA.jsp">普通换药医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc81" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocHuaA" name="doc81" checked="checked"><a href="doctor/vdocYanA.jsp">专家化验医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc80" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocHuaA" name="doc80" checked="checked"><a href="doctor/pdocYanA.jsp">普通化验医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc31" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocLiA" name="doc31" checked="checked"><a href="doctor/vdocYanA.jsp">专家理疗医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc30" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocLiA" name="doc30" checked="checked"><a href="doctor/pdocYanA.jsp">普通理疗医生A</a></td>
				</tr>
				</table>
				</div>
			<br><br>
			<input type="submit" value="提交" onclick="check()">
		</form>
	</center>
	
</body>
</html>