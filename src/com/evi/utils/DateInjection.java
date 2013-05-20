package com.evi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateInjection {
	Date dNow;
	SimpleDateFormat ft ;
	public DateInjection() {

	}

	public String returnInjectionDate() {
		dNow = new Date();
		ft= new SimpleDateFormat("MMM dd'th' yyyy',' HH:mm");
		ft.setTimeZone(TimeZone.getTimeZone("UTC"));
		return ft.format(dNow);
	}

}
