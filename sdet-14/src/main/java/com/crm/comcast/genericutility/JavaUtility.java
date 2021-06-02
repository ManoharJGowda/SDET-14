package com.crm.comcast.genericutility;

import java.util.Date;
import java.util.Random;

/**
 *   Java Utility class help us to get random data & current system data & time 
 * @author Deepak
 *
 */
public class JavaUtility {
	/**
	 *   used to get random number with in the limit of 5000
	 * @return   randomNum
	 */
	public static int getRanDomNum() {
		Random ram = new Random();
		int randomNum = ram.nextInt(5000);
		return randomNum;
		
	}
	
	/**
	 * get current system date along with date & time 
	 * @author Deepak
	 */
	public String getCurrentSystemDate()
	{
		Date date = new Date();
		String currentDate=date.toString();
		return currentDate;
		
	}
	
	/**
	 * get current system month
	 * @author Deepak
	 */
	public int getMonth() {
		Date date = new Date();
		  return date.getMonth();
	}
	
	/**
	 * get current system date
	 * @author Deepak
	 */
	  public int getDate() {
		Date date = new Date();
		  return date.getDate();
		}
	  
		/**
		 * get current system year
		 * @author Deepak
		 */
	public int getYear() {
		Date date = new Date();
		  return date.getYear();
	}
	
	/**
	 * This method will return the system current date and time 
	 * @return system date
	 */
	public static String getSystemDate() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
}
