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
			document.getElementById('doc41').style.display='none';
			document.getElementById('doc40').style.display='none';
			document.getElementById('doc51').style.display='none';
			document.getElementById('doc50').style.display='none';
			document.getElementById('doc61').style.display='none';
			document.getElementById('doc60').style.display='none';
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
			
			var doc = p1();
			var doct = document.getElementsByName(""+doc);
			for(var i = 0;i < doct.length;i++){
				if(doct[i].checked == true){					
					doctor = i;
				}				
			}
			if(doctor == 0)   doctor = "A";
			else if (doctor == 1) doctor = "B"
			else doctor = "C";
			//ke = 0外科，1内科，2儿科，3眼科
			//ty = 0普通号，1专家号
			
			var num = ""+y+m+d+ke+ty+doctor;
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
				    	  if(num > 0 && num < 10)
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
					<td>请选择就诊科室：</td>
					<td><input type="radio" value="1" name="keshi" checked="checked" onclick="p1();BingNumber()">外科</td>
					<td><input type="radio" value="2" name="keshi" onclick="p1();BingNumber()">内科</td>
					<td><input type="radio" value="3" name="keshi" onclick="p1();BingNumber()">儿科</td>
				</tr>
				<tr>	
					<td><input type="radio" value="4" name="keshi" onclick="p1();BingNumber()">眼科</td>
					<td><input type="radio" value="5" name="keshi" onclick="p1();BingNumber()">换药室</td>
					<td><input type="radio" value="6" name="keshi" onclick="p1();BingNumber()">放射科</td>
					<td><input type="radio" value="7" name="keshi" onclick="p1();BingNumber()">口腔科</td>
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
					<td><input type="radio" value="vdocWaiA" name="doc01" checked="checked"><a href="doctor/vdocWaiA.jsp">专家外科医生A</a></td>
				   </tr>
				   <tr>
					<td><input type="radio" value="vdocWaiB" name="doc01"><a href="doctor/vdocWaiB.jsp">专家外科医生B</a></td>
					</tr>
				   <tr>
					<td><input type="radio" value="vdocWaiC" name="doc01"><a href="doctor/vdocWaiC.jsp">专家外科医生C</a></td>
				   </tr>
				  </table>
				</div>
				
				<div id="doc00">	
				<table>
					<tr>
						<td><input type="radio" value="pdocWaiA" name="doc00" checked="checked"><a href="doctor/pdocWaiA.jsp">普通外科医生A</a></td>
					</tr>
					<tr>
						<td><input type="radio" value="pdocWaiB" name="doc00"><a href="doctor/pdocWaiB.jsp">普通外科医生B</a></td>
					</tr>
					<tr>
						<td><input type="radio" value="pdocWaiC" name="doc00"><a href="doctor/pdocWaiC.jsp">普通外科医生C</a></td><td></td>
					</tr>
				</table>
				</div>
					
				<div id="doc11" class="doc">	
				<table>
					<tr>
						<td><input type="radio" value="vdocNeiA" name="doc11" checked="checked"><a href="doctor/vdocNeiA.jsp">专家内科医生A</a></td>
					</tr>
					<tr>
						<td><input type="radio" value="vdocNeiB" name="doc11"><a href="doctor/vdocNeiB.jsp">专家内科医生B</a></td>
					</tr>
					<tr>
						<td><input type="radio" value="vdocNeiC" name="doc11"><a href="doctor/vdocNeiC.jsp">专家内科医生C</a></td><td></td>
					</tr>
				</table>
				</div>
				<div id="doc10" class="doc">	
				<table>
					<tr>
						<td><input type="radio" value="pdocNeiA" name="doc10" checked="checked"><a href="doctor/pdocNeiA.jsp">普通内科医生A</a></td>
					</tr>
					<tr>
						<td><input type="radio" value="pdocNeiB" name="doc10"><a href="doctor/pdocNeiB.jsp">普通内科医生B</a></td>
					</tr>
					<tr>
						<td><input type="radio" value="pdocNeiC" name="doc10"><a href="doctor/pdocNeiC.jsp">普通内科医生C</a></td><td></td>
					</tr>
				</table>	
				</div>
				
				<div id="doc21" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocErA" name="doc21" checked="checked"><a href="doctor/vdocErA.jsp">专家儿科医生A</a></td>
				</tr>
				<tr>
					<td><input type="radio" value="vdocErB" name="doc21"><a href="doctor/vdocErB.jsp">专家儿科医生B</a></td>
				</tr>
				<tr>	
					<td><input type="radio" value="vdocErC" name="doc21"><a href="doctor/vdocErC.jsp">专家儿科医生C</a></td><td></td>
				</tr>
				</table>
				</div>
				<div id="doc20" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocErA" name="doc20" checked="checked"><a href="doctor/pdocErA.jsp">普通儿科医生A</a></td>
				</tr>
				<tr>
					<td><input type="radio" value="pdocErB" name="doc20"><a href="doctor/pdocErB.jsp">普通儿科医生B</a></td>
				</tr>
				<tr>
					<td><input type="radio" value="pdocErC" name="doc20"><a href="doctor/pdocErC.jsp">普通儿科医生C</a></td><td></td>
				</tr>
				</table>
				</div>
				
				<div id="doc31" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocYanA" name="doc31" checked="checked"><a href="doctor/vdocYanA.jsp">专家眼科医生A</a></td>
				</tr>
				<tr>
					<td><input type="radio" value="vdocYanB" name="doc31"><a href="doctor/vdocYanB.jsp">专家眼科医生B</a></td>
				</tr>
				<tr>
					<td><input type="radio" value="vdocYanC" name="doc31"><a href="doctor/vdocYanC.jsp">专家眼科医生C</a></td><td></td>
				</tr>
				</table>
				</div>
				<div id="doc30" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocYanA" name="doc30" checked="checked"><a href="doctor/pdocYanA.jsp">普通眼科医生A</a></td>
				</tr>
				<tr>
					<td><input type="radio" value="pdocYanB" name="doc30"><a href="doctor/pdocYanB.jsp">普通眼科医生B</a></td>
				</tr>
				<tr>
					<td><input type="radio" value="pdocYanC" name="doc30"><a href="doctor/pdocYanC.jsp">普通眼科医生C</a></td><td></td>
				</tr>
				</table>
				</div>
				
				<div id="doc41" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocHuanA" name="doc41" checked="checked"><a href="doctor/vdocHushi.jsp">专家换药护士A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc40" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocHuanA" name="doc40" checked="checked"><a href="doctor/pdocHushi.jsp">普通换药护士A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc51" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocFangA" name="doc51" checked="checked"><a href="doctor/vdocFang.jsp">专家放射科医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc50" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocFangA" name="doc50" checked="checked"><a href="doctor/pdocFang.jsp">普通放射科医生A</a></td>
				</tr>
				</table>
				</div>
				
				<div id="doc61" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="vdocKouA" name="doc61" checked="checked"><a href="doctor/vdocKou.jsp">专家口腔医生A</a></td>
				</tr>
				</table>
				</div>
				<div id="doc60" class="doc">	
				<table>
				<tr>
					<td><input type="radio" value="pdocKouA" name="doc60" checked="checked"><a href="doctor/pdocKou.jsp">普通口腔医生A</a></td>
				</tr>
				</table>
				</div>
			<br><br>
			<input type="submit" value="提交" onclick="check()">
		</form>
	</center>
	
</body>
</html>