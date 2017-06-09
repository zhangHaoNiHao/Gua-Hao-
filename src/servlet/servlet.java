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
		out.println("<h1>�Һųɹ�</h1>");
		out.println("<hr>");		
		out.println("<h2>��ǰ��ҽ�����Ŷ����Ϊ��</h2>");
		out.println("</center>");
		out.println("<br>");
		out.println(a);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		int a=Integer.parseInt((String)request.getParameter("keshi"));//�Һſ���
		String type = (String)request.getParameter("type");
		String numbe = (String)request.getParameter("numInput");  
		//��������
		int num1=Integer.parseInt(getServletContext().getAttribute("number").toString());
		String num = "";
		if(num1 > 0 && num1 < 9)
  		  num = "00"+num1;
		else if(num1 >= 10 && num1 <= 99)
  		  num="0"+num1;
		String number = ""+numbe+num;
		//��ȡʱ��
		Date date1 = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss").format(date1);
		Jiuzhen j[] = Jiuzhen.readDataGua2();//��ȡ�ļ�
		Jiuzhen d[] = new Jiuzhen[j.length+1];
		for(int i=0;i<j.length;i++)
		{
			d[i] = j[i];
		}
		
		System.out.println("����"+num1);
		System.out.println("������"+number);
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
			//�ж�ҽ���Ķ�������Ŷ�������������С��10��������ӣ�����10��Һ�ʧ��
			Jiuzhen.num1 += 1;	
			if(Jiuzhen.num1 < 11)
			{
				Jiuzhen.queuePWaiA.offer(number);
				d[j.length] = new Jiuzhen(Jiuzhen.queuePWaiA.peek(),"���","��ͨ���ҽ��A",date);
				Jiuzhen.writeDataGua2(d);
				System.out.println("������"+number);
				Display(request,response,Jiuzhen.queuePWaiA);
			}
			else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocWaiB":
			Jiuzhen.num2 +=1;		
			if(Jiuzhen.num2 < 11)
			{
			Jiuzhen.queuePWaiB.offer(number);
			d[j.length] = new Jiuzhen(number,"���","��ͨ���ҽ��B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePWaiB);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocWaiC":
			Jiuzhen.num3 +=1;	
			if(Jiuzhen.num3 < 11)
			{
				Jiuzhen.queuePWaiC.offer(number);
				d[j.length] = new Jiuzhen(number,"���","��ͨ���ҽ��C",date);
				Jiuzhen.writeDataGua2(d);
				Display(request,response,Jiuzhen.queuePWaiC);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocWaiA":
			Jiuzhen.num4 +=1;	
			if(Jiuzhen.num3 < 11)
			{
				Jiuzhen.queueVWaiA.offer(number);
				d[j.length] = new Jiuzhen(number,"���","ר�����ҽ��A",date);
				Jiuzhen.writeDataGua2(d);
				Display(request,response,Jiuzhen.queueVWaiA);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocWaiB":
			Jiuzhen.num5 +=1;			
			if(Jiuzhen.num5 < 11)
			{
			Jiuzhen.queueVWaiB.offer(number);
			d[j.length] = new Jiuzhen(number,"���","ר�����ҽ��B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVWaiB);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocWaiC":
			Jiuzhen.num6 +=1;
			if(Jiuzhen.num6 < 11)
			{
			Jiuzhen.queueVWaiC.offer(number);
			d[j.length] = new Jiuzhen(number,"���","ר�����ҽ��C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePWaiC);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocNeiA":
			Jiuzhen.num7 +=1;	
			if(Jiuzhen.num7 < 11){
			Jiuzhen.queuePNeiA.offer(number);
			d[j.length] = new Jiuzhen(number,"�ڿ�","��ͨ�ڿ�ҽ��A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePNeiA);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocNeiB":
			Jiuzhen.num8 +=1;	
			if(Jiuzhen.num8 < 11){
			Jiuzhen.queuePNeiB.offer(number);
			d[j.length] = new Jiuzhen(number,"�ڿ�","��ͨ�ڿ�ҽ��B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePNeiB);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocNeiC":
			Jiuzhen.num9 +=1;		
			if(Jiuzhen.num9 < 11){
			Jiuzhen.queuePNeiC.offer(number);
			d[j.length] = new Jiuzhen(number,"�ڿ�","��ͨ�ڿ�ҽ��C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePNeiC);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocNeiA":
			Jiuzhen.num10 +=1;	
			if(Jiuzhen.num10 < 11){
			Jiuzhen.queueVNeiA.offer(number);
			d[j.length] = new Jiuzhen(number,"�ڿ�","ר���ڿ�ҽ��A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVNeiA);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocNeiB":
			Jiuzhen.num11 +=1;		
			if(Jiuzhen.num11 < 11){
			Jiuzhen.queueVNeiB.offer(number);
			d[j.length] = new Jiuzhen(number,"�ڿ�","ר���ڿ�ҽ��B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVNeiB);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocNeiC":
			Jiuzhen.num12 +=1;		
			if(Jiuzhen.num12 < 11){
			Jiuzhen.queueVNeiC.offer(number);
			d[j.length] = new Jiuzhen(number,"�ڿ�","ר���ڿ�ҽ��C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVNeiC);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocErA":
			Jiuzhen.num13 +=1;		
			if(Jiuzhen.num13 < 11){
			Jiuzhen.queuePErA.offer(number);
			d[j.length] = new Jiuzhen(number,"����","��ͨ����ҽ��A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePErA);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocErB":
			Jiuzhen.num14 +=1;		
			if(Jiuzhen.num14 < 11){
			Jiuzhen.queuePErB.offer(number);
			d[j.length] = new Jiuzhen(number,"����","��ͨ����ҽ��B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePErB);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocErC":
			Jiuzhen.num15 +=1;	
			if(Jiuzhen.num15 < 11){
			Jiuzhen.queuePErC.offer(number);
			d[j.length] = new Jiuzhen(number,"����","��ͨ����ҽ��C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePErC);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocErA":
			Jiuzhen.num16 +=1;		
			if(Jiuzhen.num16 < 11){
			Jiuzhen.queueVErA.offer(number);
			d[j.length] = new Jiuzhen(number,"����","ר�Ҷ���ҽ��A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVErA);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocErB":
			Jiuzhen.num17 +=1;		
			if(Jiuzhen.num17 < 11){
			Jiuzhen.queueVErB.offer(number);
			Jiuzhen.queueVErA.offer(number);
			d[j.length] = new Jiuzhen(number,"����","ר�Ҷ���ҽ��B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVErB);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocErC":
			Jiuzhen.num18 +=1;	
			if(Jiuzhen.num18 < 11){
			Jiuzhen.queueVErC.offer(number);
			Jiuzhen.queueVErA.offer(number);
			d[j.length] = new Jiuzhen(number,"����","ר�Ҷ���ҽ��C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVErC);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocYanA":
			Jiuzhen.num19 +=1;	
			if(Jiuzhen.num19 < 11){
			Jiuzhen.queuePYanA.offer(number);
			Jiuzhen.queueVErA.offer(number);
			d[j.length] = new Jiuzhen(number,"�ۿ�","��ͨ�ۿ�ҽ��A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePYanA);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocYanB":
			Jiuzhen.num20 +=1;		
			if(Jiuzhen.num20 < 11){
			Jiuzhen.queuePYanB.offer(number);
			d[j.length] = new Jiuzhen(number,"�ۿ�","��ͨ�ۿ�ҽ��B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePYanB);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "pdocYanC":
			Jiuzhen.num21 +=1;	
			if(Jiuzhen.num21 < 11){
			Jiuzhen.queuePYanC.offer(number);
			d[j.length] = new Jiuzhen(number,"�ۿ�","��ͨ�ۿ�ҽ��C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queuePYanC);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocYanA":
			Jiuzhen.num22 +=1;		
			if(Jiuzhen.num22 < 11){
			Jiuzhen.queueVYanA.offer(number);
			d[j.length] = new Jiuzhen(number,"�ۿ�","ר���ۿ�ҽ��A",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVYanA);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocYanB":
			Jiuzhen.num23 +=1;	
			if(Jiuzhen.num23 < 11){
			Jiuzhen.queueVYanB.offer(number);
			d[j.length] = new Jiuzhen(number,"�ۿ�","ר���ۿ�ҽ��B",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVYanB);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		case "vdocYanC":
			Jiuzhen.num24 +=1;		
			if(Jiuzhen.num24 < 11){
			Jiuzhen.queueVYanC.offer(number);
			d[j.length] = new Jiuzhen(number,"�ۿ�","ר���ۿ�ҽ��C",date);
			Jiuzhen.writeDataGua2(d);
			Display(request,response,Jiuzhen.queueVYanC);
			}else{
				out.println("<h1 align='center'>��������</h1>");
			}
			break;
		}
		
		
	}

}
