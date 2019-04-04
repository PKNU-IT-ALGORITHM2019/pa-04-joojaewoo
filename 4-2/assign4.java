package 알고리즘4주차;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class assign4 {
	static webLog list[]=new webLog [200000];
	static String msg;
	static int count =0;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		while(true)
		{
			System.out.print("$ ");
			String message = scan.next();
			if (message.contentEquals("read"))
			{msg = scan.next();
			read(msg);}
			else if (message.contentEquals("sort"))
			{msg = scan.next();
			sort(msg);}
			else if (message.contentEquals("print"))
			print();
			else if (message.contentEquals("exit"))
			{break;}
		}
		scan.close();
	}
	static void read(String str) {
		try {
			Scanner infile = new Scanner(new File(str));
			String buffer = infile.nextLine();
			while(infile.hasNext()) {
				buffer = infile.nextLine();
				if(!buffer.contentEquals(""))
				{String temp []=buffer.split(",");
				list[count]=new webLog(temp[0],temp[1],temp[2],temp[3]);
				count++;
				}
			}
			infile.close();
		}
		catch(FileNotFoundException e) {System.out.println("No file");
		System.exit(0);}
	}
	static void sort(String str) {
		if(str.equals("-t"))
		Arrays.sort(list, 0, count-1);
		else if(str.equals("-ip"))
		Arrays.sort(list,new webLogIPComparator());
	}
	static void print() {
		if(msg.equals("-ip"))
		{for(int i=0;i<count;i++)
			{System.out.println(list[i].IP);
			System.out.println("\tTime : "+list[i].Date);
			System.out.println("\tURL : "+list[i].URL);
			System.out.println("\tStatus : "+list[i].Status);	
			}}
		else if(msg.equals("-t"))
		{for(int i=0;i<count;i++)
			{System.out.println(list[i].Date);
			System.out.println("\tIP : "+list[i].IP);
			System.out.println("\tURL : "+list[i].URL);
			System.out.println("\tStatus : "+list[i].Status);	
			}}
		else
		{for(int i=0;i<count;i++)
		{System.out.println("Time : "+list[i].Date);
		System.out.println("IP : "+list[i].IP);
		System.out.println("URL : "+list[i].URL);
		System.out.println("Status : "+list[i].Status);	
		}}

	}
}
