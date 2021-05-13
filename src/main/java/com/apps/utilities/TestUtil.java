package com.apps.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.apps.base.Page;


public class TestUtil extends Page {
	
	public static String screenShotName;
	
	public static void captureScreenshot() throws IOException {
		
		Date d=new Date();
		screenShotName=d.toString().replace(" ", "_").replace(":", "_")+".jpg";
		
		
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName));
		
		
	}
	
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m1) {
		
		String sheetName=m1.getName();
		int rowCount=excel.getRowCount(sheetName);
		log.info("Excel Row Size is"+rowCount);
		int colCount=excel.getColumnCount(sheetName);
		log.info("Excel column Size is"+colCount);
		
		
		Object[][] data=new Object[rowCount-1][colCount];
		//new Object[2][3]
		
	
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++) {
			
			for(int colNum=0;colNum<colCount;colNum++) {
		
		data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
		
			}
		}
		
		
		return data;
		
		
	}
	
	
	

	
	
	
	

}
