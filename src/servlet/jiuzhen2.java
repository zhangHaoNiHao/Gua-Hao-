package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import text.Jiuzhen;

/**
 * Servlet implementation class jiuzhen2
 */
@WebServlet("/jiuzhen2")
public class jiuzhen2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jiuzhen2() {
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
	void display(HttpServletRequest request, HttpServletResponse response,Queue<String> a) throws IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<center>");
		out.println("<h1>就诊结束</h1>");
		out.println("<hr>");		
		out.println("<h2>当前该医生的排队情况为：</h2>");
		if(a.peek() == null)
		{
			out.print("<h1>队列为空！</h1>");
		}
		else{		
		out.println("<br>");
		out.println(a);
		}
		out.println("</center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String a = (String)request.getParameter("jiuzhen");
		//获取时间
		Date date1 = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss").format(date1);
		String arrive = (String)request.getParameter("arrive"); //病人是否到达
		System.out.println(arrive);
		Jiuzhen j[] = Jiuzhen.readData2();	
		System.out.println("读取文件");
		
		Jiuzhen d[] = new Jiuzhen[j.length+1];
		for(int i=0;i<j.length;i++)
		{
			d[i] = j[i];
		}
		switch (a)
		{
			case "1":
			{
				String doc = (String)request.getParameter("Wai");
				switch(doc)
				{
				case "PWaiA":
					if(Jiuzhen.queuePWaiA.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePWaiA.peek(),"外科","普通外科医生A",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件waiA");
					Jiuzhen.queuePWaiA.poll();
					display(request,response,Jiuzhen.queuePWaiA);
					}
					break;
				case "PWaiB":
					if(Jiuzhen.queuePWaiB.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePWaiB.peek(),"外科","普通外科医生B",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件waiB");
					Jiuzhen.queuePWaiB.poll();
					display(request,response,Jiuzhen.queuePWaiB);
					}
					break;
				case "PWaiC":
					if(Jiuzhen.queuePWaiC.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePWaiC.peek(),"外科","普通外科医生C",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件waiC");
					Jiuzhen.queuePWaiC.poll();
					display(request,response,Jiuzhen.queuePWaiC);
					}
					break;	
				case "VWaiA":
					if(Jiuzhen.queueVWaiA.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVWaiA.peek(),"外科","专家外科医生A",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件waiA");
					Jiuzhen.queueVWaiA.poll();
					display(request,response,Jiuzhen.queueVWaiA);
					}
					break;
				case "VWaiB":
					if(Jiuzhen.queueVWaiB.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVWaiB.peek(),"外科","专家外科医生B",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件waiB");
					Jiuzhen.queueVWaiB.poll();
					display(request,response,Jiuzhen.queueVWaiB);
					}
					break;
				case "VWaiC":
					if(Jiuzhen.queueVWaiC.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVWaiC.peek(),"外科","专家外科医生C",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件waiC");
					Jiuzhen.queueVWaiC.poll();
					display(request,response,Jiuzhen.queueVWaiC);
					}
					break;	
				}		
			}	
			break;
			case "2":
			{
				String doc = (String)request.getParameter("Nei");
				switch(doc)
				{
				case "PNeiA":
					if(Jiuzhen.queuePNeiA.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePNeiA.peek(),"内科","普通内科医生A",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件NeiA");
					Jiuzhen.queuePNeiA.poll();
					display(request,response,Jiuzhen.queuePNeiA);
					}
					break;
				case "PNeiB":
					if(Jiuzhen.queuePNeiB.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePNeiB.peek(),"内科","普通内科医生B",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件NeiB");
					Jiuzhen.queuePNeiB.poll();
					display(request,response,Jiuzhen.queuePNeiB);
					}
					break;
				case "PNeiC":
					if(Jiuzhen.queuePNeiC.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePNeiC.peek(),"内科","普通内科医生C",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件NeiC");
					Jiuzhen.queuePNeiC.poll();
					display(request,response,Jiuzhen.queuePNeiC);
					}
					break;	
				case "VNeiA":
					if(Jiuzhen.queueVNeiA.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVNeiA.peek(),"内科","专家内科医生A",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件NeiA");
					Jiuzhen.queueVNeiA.poll();
					display(request,response,Jiuzhen.queueVNeiA);
					}
					break;
				case "VNeiB":
					if(Jiuzhen.queueVNeiB.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVNeiB.peek(),"内科","专家内科医生B",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件NeiB");
					Jiuzhen.queueVNeiB.poll();
					display(request,response,Jiuzhen.queueVNeiB);
					}
					break;
				case "VNeiC":
					if(Jiuzhen.queueVNeiC.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVNeiC.peek(),"内科","专家内科医生C",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件NeiC");
					Jiuzhen.queueVNeiC.poll();
					display(request,response,Jiuzhen.queueVNeiC);
					}
					break;	
				}	
			}
			break;
			case "3":
			{
				String doc = (String)request.getParameter("Er");
				switch(doc)
				{
				case "PErA":
					if(Jiuzhen.queuePErA.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePErA.peek(),"儿科","普通儿科医生A",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件ErA");
					Jiuzhen.queuePErA.poll();
					display(request,response,Jiuzhen.queuePErA);
					}
					break;
				case "PErB":
					if(Jiuzhen.queuePErB.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePErB.peek(),"儿科","普通儿科医生B",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件ErB");
					Jiuzhen.queuePErB.poll();
					display(request,response,Jiuzhen.queuePErB);
					}
					break;
				case "PErC":
					if(Jiuzhen.queuePErC.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePErC.peek(),"儿科","普通儿科医生C",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件ErC");
					Jiuzhen.queuePErC.poll();
					display(request,response,Jiuzhen.queuePErC);
					}
					break;	
				case "VErA":
					if(Jiuzhen.queueVErA.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVErA.peek(),"儿科","专家儿科医生A",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件ErA");
					Jiuzhen.queueVErA.poll();
					display(request,response,Jiuzhen.queueVErA);
					}
					break;
				case "VErB":
					if(Jiuzhen.queueVErB.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVErB.peek(),"儿科","专家儿科医生B",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件ErB");
					Jiuzhen.queueVErB.poll();
					display(request,response,Jiuzhen.queueVErB);
					}
					break;
				case "VErC":
					if(Jiuzhen.queueVErC.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVErC.peek(),"儿科","专家儿科医生C",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件ErC");
					Jiuzhen.queueVErC.poll();
					display(request,response,Jiuzhen.queueVErC);
					}
					break;	
				}	
			}
			break;
			case "4":
			{
				String doc = (String)request.getParameter("Yan");
				switch(doc)
				{
				case "PYanA":
					if(Jiuzhen.queuePYanA.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePYanA.peek(),"眼科","普通眼科医生A",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件YanA");
					Jiuzhen.queuePYanA.poll();
					display(request,response,Jiuzhen.queuePYanA);
					}
					break;
				case "PYanB":
					if(Jiuzhen.queuePYanB.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePYanB.peek(),"眼科","普通眼科医生B",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件YanB");
					Jiuzhen.queuePYanB.poll();
					display(request,response,Jiuzhen.queuePYanB);
					}
					break;
				case "PYanC":
					if(Jiuzhen.queuePYanC.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queuePYanC.peek(),"眼科","普通眼科医生C",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件YanC");
					Jiuzhen.queuePYanC.poll();
					display(request,response,Jiuzhen.queuePYanC);
					}
					break;	
				case "VYanA":
					if(Jiuzhen.queueVYanA.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVYanA.peek(),"眼科","专家眼科医生A",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件YanA");
					Jiuzhen.queueVYanA.poll();
					display(request,response,Jiuzhen.queueVYanA);
					}
					break;
				case "VYanB":
					if(Jiuzhen.queueVYanB.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVYanB.peek(),"眼科","专家眼科医生B",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件YanB");
					Jiuzhen.queueVYanB.poll();
					display(request,response,Jiuzhen.queueVYanB);
					}
					break;
				case "VYanC":
					if(Jiuzhen.queueVYanC.peek() == null)
					{
						out.print("<center>");
						out.print("<h1>队列为空！</h1>");
						out.print("<center>");
					}
					else{
					d[j.length] = new Jiuzhen(Jiuzhen.queueVYanC.peek(),"眼科","专家眼科医生C",date,arrive);
					Jiuzhen.writeData2(d);
					System.out.println("就诊记录输入文件YanC");
					Jiuzhen.queueVYanC.poll();
					display(request,response,Jiuzhen.queueVYanC);
					}
					break;	
				}	
			}
			break;
		}
	}

}
