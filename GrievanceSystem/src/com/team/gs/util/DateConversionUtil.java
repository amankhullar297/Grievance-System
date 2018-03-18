package com.team.gs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversionUtil {

	public static final Long dateToLong(String date)
	{
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		try {
		    Date d = f.parse(date);
		    long milliseconds = d.getTime();
		    return milliseconds;
		} catch (ParseException e) {
		    e.printStackTrace();
		    return null;
		}
	}
	

	public static final String longTodate(Long date)
	{
		if(date!=null){
			
		
		
		    Date d = new Date(date);
		    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		   return f.format(d);
		  // return d;
	}
		else{
			return " ";}
		}
	}
	

