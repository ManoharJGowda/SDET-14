package com.crm.comcast.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	static Connection con= null;
	static ResultSet result = null;
	
	/**
	 * This method will help to establish the connection with database
	 * @author Chaitra
	 */
	
	public static void connectToDB() {
	Driver driverRef;
	    try
	    {
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2 Get Connection to Database// provide database name
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "root");
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * This method will help to close the database connection
	 * @author Chaitra
	 * @throws SQLException
	 */
	public static void closeDB() throws SQLException
	{
		con.close();
	}
	
	/**
	 * This method is used to execute a Select query
	 * @author Chaitra
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet ExecuteQuery(String query) throws SQLException
	{
		result = con.createStatement().executeQuery(query);
		return result;
	}
	
	/**
	 * This method will execute a select query and return the result.
	 * @author Chaitra
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public static String executeQueryAndGetData(String query,int columnIndex,String expData) throws SQLException
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnIndex).equals(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "data verified in db");
			return expData;
		}
		else
		{
			System.out.println(columnIndex + "data not verifeied in db");
			return expData;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
