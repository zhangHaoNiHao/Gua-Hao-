package text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Jiuzhen {
	
   
	public String number;
	public String keshi;
	public String doctor;
	public String date ;
	public String arrive;
	
	public Jiuzhen(String num,String ke,String doc,String da,String arr){
		number = num;
		keshi = ke;
		doctor = doc;
		date = da;
		arrive = arr;
	}
	public Jiuzhen(String num,String ke,String doc,String da){
		number = num;
		keshi = ke;
		doctor = doc;
		date = da;
	}
	public static int num1 = 0;
	public static int num2 = 0;
	public static int num3 = 0;
	public static int num4 = 0;
	public static int num5 = 0;
	public static int num6 = 0;
	public static int num7 = 0;
	public static int num8 = 0;
	public static int num9 = 0;
	public static int num10 = 0;
	public static int num11=  0;
	public static int num12=  0;
	public static int num13=  0;
	public static int num14 = 0;
	public static int num15 = 0;
	public static int num16 = 0;
	public static int num17 = 0;
	public static int num18 = 0;
	public static int num19 = 0;
	public static int num20 = 0;	
	public static int num21 = 0;
	public static int num22 = 0;
	public static int num23 = 0;
	public static int num24 = 0;
	public static int num25 = 0;
	public static int num26 = 0;
	public static int num27 = 0;	
	public static int num28 = 0;
	public static int num29 = 0;
	public static int num30 = 0;
	public static Queue<String> queueVWaiA = new LinkedList<String>();
	public static Queue<String> queueVWaiB = new LinkedList<String>();
	public static Queue<String> queueVWaiC = new LinkedList<String>();
	public static Queue<String> queuePWaiA = new LinkedList<String>();
	public static Queue<String> queuePWaiB = new LinkedList<String>();
	public static Queue<String> queuePWaiC = new LinkedList<String>();
	public static Queue<String> queueVNeiA = new LinkedList<String>();
	public static Queue<String> queueVNeiB = new LinkedList<String>();
	public static Queue<String> queueVNeiC = new LinkedList<String>();
	public static Queue<String> queuePNeiA = new LinkedList<String>();
	public static Queue<String> queuePNeiB = new LinkedList<String>();
	public static Queue<String> queuePNeiC = new LinkedList<String>();
	public static Queue<String> queueVErA = new LinkedList<String>();
	public static Queue<String> queueVErB = new LinkedList<String>();
	public static Queue<String> queueVErC = new LinkedList<String>();
	public static Queue<String> queuePErA = new LinkedList<String>();
	public static Queue<String> queuePErB = new LinkedList<String>();
	public static Queue<String> queuePErC = new LinkedList<String>();
	public static Queue<String> queueVYanA = new LinkedList<String>();
	public static Queue<String> queueVYanB = new LinkedList<String>();
	public static Queue<String> queueVYanC = new LinkedList<String>();
	public static Queue<String> queuePYanA = new LinkedList<String>();
	public static Queue<String> queuePYanB = new LinkedList<String>();
	public static Queue<String> queuePYanC = new LinkedList<String>();
	public static Queue<String> queuePKou = new LinkedList<String>();
	public static Queue<String> queueVKou = new LinkedList<String>();
	public static Queue<String> queuePFang = new LinkedList<String>();
	public static Queue<String> queueVFang = new LinkedList<String>();
	public static Queue<String> queuePHuan = new LinkedList<String>();
	public static Queue<String> queueVHuan = new LinkedList<String>();
	
	
	public Jiuzhen(){	}
	
	//就诊记录，写入文件
	public static void writeData2(Jiuzhen[] jiu) throws IOException
	{
		PrintWriter out=new PrintWriter(new FileWriter("就诊记录.txt"));
		out.println(jiu.length);
		for(int i=0;i<jiu.length;i++)
		{
			jiu[i].writeData1(out);
		}
		out.close();
	}
	//病历号，科室，医生，时间
	private void writeData1(PrintWriter out) {
		// TODO Auto-generated method stub
		out.println(number+" "+keshi+" "+doctor+" "+date+" "+arrive);
	}
	
	//挂号记录，写入文件
	public static void writeDataGua2(Jiuzhen[] jiu) throws IOException
	{
		PrintWriter out=new PrintWriter(new FileWriter("挂号记录.txt"));
		out.println(jiu.length);
		for(int i=0;i<jiu.length;i++)
		{
			jiu[i].writeDataGua1(out);
		}
		out.close();
	}
	//病历号，科室，医生，时间
	private void writeDataGua1(PrintWriter out) {
		// TODO Auto-generated method stub
		out.println(number+" "+keshi+" "+doctor+" "+date);
	}
	
	//读取就诊记录
	public static Jiuzhen[] readData2() throws IOException
	{
		File f = new File("就诊记录.txt");
		Jiuzhen []a;
		if(!f.exists())
		{
			a=new Jiuzhen[0];
			writeData2(a);
			System.out.println("文件不存在，新建文件1");
			return a;
		}
		Scanner in=new Scanner(new BufferedReader(new FileReader(f)));
		int n=in.nextInt();
		a=new Jiuzhen[n];
		for(int i=0;i<n;i++)
		{
			a[i] = new Jiuzhen();
			a[i].readData1(in);
		}
		System.out.println("新建文件2");
		in.close();
		return a;
	}
	private void readData1(Scanner scan) {
		// TODO Auto-generated method stub
		number = scan.next();
		keshi = scan.next();
		doctor = scan.next();
		date = scan.next();
		arrive = scan.next();
	}
	//读取挂号记录
	public static Jiuzhen[] readDataGua2() throws IOException
	{
		File f = new File("挂号记录.txt");
		Jiuzhen []a;
		if(!f.exists())
		{
			a=new Jiuzhen[0];
			writeDataGua2(a);
			System.out.println("文件不存在，新建文件1");
			return a;
		}
		Scanner in=new Scanner(new BufferedReader(new FileReader(f)));
		int n=in.nextInt();
		a=new Jiuzhen[n];
		for(int i=0;i<n;i++)
		{
			a[i] = new Jiuzhen();
			a[i].readDataGua1(in);
		}
		System.out.println("新建文件2");
		in.close();
		return a;
	}
	private void readDataGua1(Scanner scan) {
		// TODO Auto-generated method stub
		number = scan.next();
		keshi = scan.next();
		doctor = scan.next();
		date = scan.next();
	}

}
