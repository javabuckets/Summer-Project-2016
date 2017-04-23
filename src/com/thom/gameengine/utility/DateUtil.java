package com.thom.gameengine.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil 
{
	public static String date;
	
	public static String getDate()
	{
		Date dNow = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
		
		return ft.format(dNow).toString();
	}
	
	public static String getDateToday()
	{
		String unformated = getDate();
		
		String day = unformated.substring(8);
		String month = unformated.substring(5, 7);
		String year = unformated.substring(0, 4);
		
		String formated = day + "-" + month + "-" + year;
		
		return formated;
	}
}
