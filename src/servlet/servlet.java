package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import com.sun.glass.ui.Application;

import text.Jiuzhen;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	void Display(HttpServletRequest request, HttpServletResponse response,Queue<String> a) throws IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<center>");
		out.println("<h1>挂号成功</h1>");
		out.println("<hr>");		
		out.println("<h2>当前该医生的排队情况为：</h2>");
		out.println("</center>");
		out.println("<br>");
		out.println(a);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		int a=Integer.parseInt((String)request.getParameter("keshi"));//挂号科室
		String type = (String)request.getParameter("type");
		String numbe = (String)request.getParameter("numInput");  
		//访问人数
		int num1=Integer.parseInt(getServletContext().getAttribute("number").toString());
		String num = "";
		if(num1 > 0 && num1 < 9)
  		  num = "00"+num1;
		else if(num1 >= 10 && num1 <= 99)
  		  num="0"+num1;
		String number = ""+numbe+num;
		//获取时间
		Date date1 = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss").format(date1);
		Jiuzhen j[] = Jiuzhen.readDataGua2();//读取文件
		Jiuzhen d[] = new Jiuzhen[j.length+1];
		for(int i=0;i<j.length;i++)
		{
			d[i] = j[i];
		}
		
		System.out.println("次数"+num1);
		System.out.println("病历号"+number);
		num1+=1;
		getServletContext().setAttribute("number", num1);
		getServletContext().setAttribute("Strnumber", num);
		String doctor = "";
		
		if(a == 1 && type.equals("putong"))
		{
			doctor = (String)request.getParameter("doc00");
		}
		else if(a == 1 && type.equals("vip"))
		{
			doctor = (String)request.getParameter("doc01");
		}
		else if(a == 2 && type.equals("vip"))
		{
			doctor = (String)request.getParameter("doc11");
		}
		else if(a == 2 && type.equals("putong"))
		{
			doctor = (String)request.getParameter("doc10");
		}
		else if(a == 3 && type.equals("vip"))
		{
			doctor = (String)request.getParameter("doc21");
		}
		else if(a == 3 && type.equals("putong"))
		{
			doctor = (String)request.getParameter("doc20");
		}
		else if(a == 4 && type.equals("vip"))
		{
			doctor = (String)request.getParameter("doc31");		
		}
		else if(a == 4 && type.equals("putong"))
		{
			doctor = (String)request.getParameter("doc30");
		}
		switch(doctor)
		{
		case "pdocWaiA" :
			//判断医生的队列里的排队人数，若人数小于10，正常添加，超过10则挂号失败
			Jiuzhen.num1 += 1;	
			if(Jiuzhen.num1 < 11)
			{
				Jiuzhen.queuePWaiA.offer(number);
				d[j.length] = new Jiuzhen(Jiuzhen.queuePWaiA.peek(),"外科","普通外科医生A",date);
				Jiuzhen.writeDataGua2(d);
				System.out.println("病历号"+number);
				Display(request,response,Jiuzhen.queuePWaiA);
			}
			else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocWaiB":
			Jiuzhen.num2 +=1;		
			if(Jiuzhen.num2 < 11)
			{
			Jiuzhen.queuePWaiB.offer(number);
			d[j.length] = new Jiuzhen(number,"外科","普通外科医生B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePWaiB);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocWaiC":
			Jiuzhen.num3 +=1;	
			if(Jiuzhen.num3 < 11)
			{
				Jiuzhen.queuePWaiC.offer(number);
				d[j.length] = new Jiuzhen(number,"外科","普通外科医生C",date);
				Jiuzhen.writeDataGua2(d);
				Display(request,response,Jiuzhen.queuePWaiC);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocWaiA":
			Jiuzhen.num4 +=1;	
			if(Jiuzhen.num3 < 11)
			{
				Jiuzhen.queueVWaiA.offer(number);
				d[j.length] = new Jiuzhen(number,"外科","专家外科医生A",date);
				Jiuzhen.writeDataGua2(d);
				Display(request,response,Jiuzhen.queueVWaiA);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocWaiB":
			Jiuzhen.num5 +=1;			
			if(Jiuzhen.num5 < 11)
			{
			Jiuzhen.queueVWaiB.offer(number);
			d[j.length] = new Jiuzhen(number,"外科","专家外科医生B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVWaiB);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocWaiC":
			Jiuzhen.num6 +=1;
			if(Jiuzhen.num6 < 11)
			{
			Jiuzhen.queueVWaiC.offer(number);
			d[j.length] = new Jiuzhen(number,"外科","专家外科医生C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePWaiC);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocNeiA":
			Jiuzhen.num7 +=1;	
			if(Jiuzhen.num7 < 11){
			Jiuzhen.queuePNeiA.offer(number);
			d[j.length] = new Jiuzhen(number,"内科","普通内科医生A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePNeiA);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocNeiB":
			Jiuzhen.num8 +=1;	
			if(Jiuzhen.num8 < 11){
			Jiuzhen.queuePNeiB.offer(number);
			d[j.length] = new Jiuzhen(number,"内科","普通内科医生B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePNeiB);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocNeiC":
			Jiuzhen.num9 +=1;		
			if(Jiuzhen.num9 < 11){
			Jiuzhen.queuePNeiC.offer(number);
			d[j.length] = new Jiuzhen(number,"内科","普通内科医生C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePNeiC);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocNeiA":
			Jiuzhen.num10 +=1;	
			if(Jiuzhen.num10 < 11){
			Jiuzhen.queueVNeiA.offer(number);
			d[j.length] = new Jiuzhen(number,"内科","专家内科医生A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVNeiA);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocNeiB":
			Jiuzhen.num11 +=1;		
			if(Jiuzhen.num11 < 11){
			Jiuzhen.queueVNeiB.offer(number);
			d[j.length] = new Jiuzhen(number,"内科","专家内科医生B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVNeiB);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocNeiC":
			Jiuzhen.num12 +=1;		
			if(Jiuzhen.num12 < 11){
			Jiuzhen.queueVNeiC.offer(number);
			d[j.length] = new Jiuzhen(number,"内科","专家内科医生C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVNeiC);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocErA":
			Jiuzhen.num13 +=1;		
			if(Jiuzhen.num13 < 11){
			Jiuzhen.queuePErA.offer(number);
			d[j.length] = new Jiuzhen(number,"儿科","普通儿科医生A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePErA);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocErB":
			Jiuzhen.num14 +=1;		
			if(Jiuzhen.num14 < 11){
			Jiuzhen.queuePErB.offer(number);
			d[j.length] = new Jiuzhen(number,"儿科","普通儿科医生B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePErB);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocErC":
			Jiuzhen.num15 +=1;	
			if(Jiuzhen.num15 < 11){
			Jiuzhen.queuePErC.offer(number);
			d[j.length] = new Jiuzhen(number,"儿科","普通儿科医生C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePErC);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocErA":
			Jiuzhen.num16 +=1;		
			if(Jiuzhen.num16 < 11){
			Jiuzhen.queueVErA.offer(number);
			d[j.length] = new Jiuzhen(number,"儿科","专家儿科医生A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVErA);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocErB":
			Jiuzhen.num17 +=1;		
			if(Jiuzhen.num17 < 11){
			Jiuzhen.queueVErB.offer(number);
			Jiuzhen.queueVErA.offer(number);
			d[j.length] = new Jiuzhen(number,"儿科","专家儿科医生B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVErB);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocErC":
			Jiuzhen.num18 +=1;	
			if(Jiuzhen.num18 < 11){
			Jiuzhen.queueVErC.offer(number);
			Jiuzhen.queueVErA.offer(number);
			d[j.length] = new Jiuzhen(number,"儿科","专家儿科医生C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVErC);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocYanA":
			Jiuzhen.num19 +=1;	
			if(Jiuzhen.num19 < 11){
			Jiuzhen.queuePYanA.offer(number);
			Jiuzhen.queueVErA.offer(number);
			d[j.length] = new Jiuzhen(number,"眼科","普通眼科医生A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePYanA);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocYanB":
			Jiuzhen.num20 +=1;		
			if(Jiuzhen.num20 < 11){
			Jiuzhen.queuePYanB.offer(number);
			d[j.length] = new Jiuzhen(number,"眼科","普通眼科医生B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePYanB);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "pdocYanC":
			Jiuzhen.num21 +=1;	
			if(Jiuzhen.num21 < 11){
			Jiuzhen.queuePYanC.offer(number);
			d[j.length] = new Jiuzhen(number,"眼科","普通眼科医生C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePYanC);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocYanA":
			Jiuzhen.num22 +=1;		
			if(Jiuzhen.num22 < 11){
			Jiuzhen.queueVYanA.offer(number);
			d[j.length] = new Jiuzhen(number,"眼科","专家眼科医生A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVYanA);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocYanB":
			Jiuzhen.num23 +=1;	
			if(Jiuzhen.num23 < 11){
			Jiuzhen.queueVYanB.offer(number);
			d[j.length] = new Jiuzhen(number,"眼科","专家眼科医生B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVYanB);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		case "vdocYanC":
			Jiuzhen.num24 +=1;		
			if(Jiuzhen.num24 < 11){
			Jiuzhen.queueVYanC.offer(number);
			d[j.length] = new Jiuzhen(number,"眼科","专家眼科医生C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVYanC);
			}else{
				out.println("<h1 align='center'>队列已满</h1>");
			}
			break;
		}
		
		
	}

}
