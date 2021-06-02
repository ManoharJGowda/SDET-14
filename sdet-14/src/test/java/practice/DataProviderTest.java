package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import @org.testng.annotations.DataProvider

public class DataProviderTest 
{		 
		 @DataProvider
		 public Object[][] provideData() {
		  //decalre 2 dimensional object array
		  Object[][] data=new Object[][] {{"Redmi", 12000, 4.5},{"Iphone", 40000, 4.5}};
		  //add product :- productName, product price and product rating
		//  data[0][0]="Redmi";
		//  data[0][1]=1200;
		//  data[0][2]=4.5;
		//  
		//  data[1][0]="Iphone";
		//  data[1][1]=40000;
		//  data[1][2]=4.2;
		 
		  return data; 
		 }
		 
		 
		 @Test(dataProvider = "provideData" )
		 public void test(String phoneName, int phonePrice, double ratings) {
		  System.out.println("PhoneName: "+phoneName+"\nPhone Price: "+phonePrice+"\nratings: "+
		 ratings);
		 }

		}


