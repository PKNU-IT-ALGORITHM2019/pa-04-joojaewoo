package 알고리즘4주차;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class assign4 {
	static webLog list[];
	static webLog list1[]=new webLog [200000];
	static int count =0;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		while(true)
		{
			System.out.print("$ ");
			String message = scan.next();
			if (message.contentEquals("read"))
			{String msg = scan.next();
			read(msg);}
			else if (message.contentEquals("sort"))
			{String msg = scan.next();
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
				list1[count]=new webLog(temp[0],temp[1],temp[2],temp[3]);
				count++;
				}
			}
			infile.close();
			list =new webLog[count];
			for(int i=0;i<count;i++)
				list[i]=list1[i];
		}
		catch(FileNotFoundException e) {System.out.println("No file");
		System.exit(0);}
	}
	static void sort(String str) {
		if(str.equals("-t"))
		Arrays.sort(list);
		else if(str.equals("-ip"))
		Arrays.sort(list,new webLogIPComparator());
	}
	static void print() {
		for(int i=0;i<count;i++)
			{System.out.println("Time : "+list[i].Date);
			System.out.println("IP : "+list[i].IP);
			System.out.println("URL : "+list[i].URL);
			System.out.println("Status : "+list[i].Status);	
			}
	}
}
