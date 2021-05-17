package com.automation.scripts;

import java.time.LocalDate;

public class DateTimeTest {
	
	public static void main(String[] args) {
		
		LocalDate Todaysdate= LocalDate.now();
		
		System.out.println(" Today Date is: "+Todaysdate);
		
		String Date=Todaysdate.toString();
		
		String[] Sdate=Date.split("-");
		
		String Year= Sdate[0];
		String Month = Sdate[1];
		String TDate=Sdate[2];
		
		System.out.println("Year: "+Year+" Month: "+Month+" Date: "+TDate);
		
		LocalDate Yesterday=Todaysdate.minusDays(1)	;
		
		LocalDate Tommorowdate=Todaysdate.plusDays(1);
		
		System.out.println(" Yesterday date: "+Yesterday);
		System.out.println(" Tommorw date : "+Tommorowdate);
		}
	

}
