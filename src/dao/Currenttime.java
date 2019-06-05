package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Currenttime {
	
	public static String gettime()
	{

	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	String s=dateFormat.format(cal.getTime());
	
	String time=s.substring(s.lastIndexOf(" ")+1);
	
	String remain=time.substring(2,5);
	
	int i=Integer.parseInt(time.substring(0,2));
	
	String result=null;
	
	if(i==0 || i==12) {
			
		
		result="12"+remain;
	}
	
	else if(i<12)
		
	{
		
		result=time.substring(0,5);
		
	}
	
	else 
	{
		
		i=i-12;
		
		result=Integer.toString(i)+remain;
		
	}
	return result;
	
	
}
	
	
	
	
	
	

	public static String getdate()
	{

	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	String s=dateFormat.format(cal.getTime());
	
	return s.substring(0,s.lastIndexOf(" "));
}
	
	
	
	
	
	
	
	
	public static String getAMPM() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String s=dateFormat.format(cal.getTime());
		
		String time=s.substring(s.lastIndexOf(" ")+1);
		
		int i=Integer.parseInt(time.substring(0, 2));
		
		String ap=null;
		
		if(i<12)
			
			ap="A.M";
		
		else
			
			ap="P.M";
		
		return ap;
	
	
	}
	
	
	public static String getday() {
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String s=dateFormat.format(cal.getTime());
		
		int day=Integer.parseInt(s.substring(0,2));
		
		int month=Integer.parseInt(s.substring(3,5));
		
		int year=Integer.parseInt(s.substring(6,10));
		
	
		
		int count=0;
		
		for(int i=2001;i<year;i++)
			
		{
			
			if(i%4==0)
				
				count=count+2;
			
			else
				
				count=count+1;
			
			
			
		}
		
		int a[]={31,59,90,120,151,181,212,243,273,304,334,365};
		
		count=count+a[month-2]+day;
		
         if(year%4==0)
			
			count++;
		
		
		//System.out.println(count);
		
		String days[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		
		return(days[count%7]);
		
	
		
	}
	
	
	
	
	
	
}