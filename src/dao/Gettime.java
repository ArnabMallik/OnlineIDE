package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gettime {
	
	public static String get_date() {
		
	DateFormat df=new SimpleDateFormat();
	
	Date date=new Date();
	
	return(df.format(date));
	
	}
	
	
}
