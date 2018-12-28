package com.Test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;



public class TestUtil {

	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]>myData=new ArrayList<Object[]>();
		try {
		
		reader=new Xls_Reader("C:\\Users\\Naresh\\eclipse-workspace\\ABSA\\src\\Excel\\Absa.xlsx");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		for(int rowNum=2; rowNum<=reader.getRowCount("RegTestData"); rowNum++) {
			
			String FirstName=reader.getCellData("RegTestData", "FirstName", rowNum);
			
			String LastName=reader.getCellData("RegTestData", "LastName", rowNum);
			
			String UserName=reader.getCellData("RegTestData", "UserNmae", rowNum);
			
			String Password=reader.getCellData("RegTestData", "Password", rowNum);

			String Email=reader.getCellData("RegTestData", "Email", rowNum);
			
			String Cell=reader.getCellData("RegTestData", "Cell", rowNum);
			
			Object ob[]= {FirstName,LastName,UserName,Password,Email,Cell};
			
		    myData.add(ob);
		    
	}
		
         return myData;
			
}
	
	}


