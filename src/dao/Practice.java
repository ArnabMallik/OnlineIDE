package dao;

import java.awt.EventQueue;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Practice {

	public static void main(String args[])
	
	{
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the number");
		
		String n=s.nextLine();
		
		int number=Integer.parseInt(n);
		
		String result=Integer.toString(number,2);
		
		System.out.println(result);
		
		int count=0;
		
		for(int i=0;i<result.length();i++)
			
		{
			
			if(result.charAt(i)=='1')
				count++;
		}
		
		System.out.println("Total no. of 1's="+count);
		
		
		
		System.out.println(Integer.parseInt("123"));
		
		
	}
	
}


