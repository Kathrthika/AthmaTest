package com.athma.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.athma.qa.utils.GeneralUtils;

public class TestBase {
	Logger logger = Logger.getLogger(TestBase.class.getName());
	
	public static Properties prop;
	public static WebDriver driver;
	
	static Workbook book;
	static Sheet sheet;
	
	
	public TestBase() throws IOException {
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\339154\\eclipse-workspace\\AthmaTesting\\src\\"
					+ "main\\java\\com\\athma\\qa\\config\\config.properties");
			prop.load(ip);
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
  @SuppressWarnings("deprecation")
public void initialize() {
	  //System.out.println("Initalize");
	  String broswerName = prop.getProperty("browser");
	  
	  if (broswerName.equals("chrome"))
	  {
		
	  System.setProperty("webdriver.chrome.driver","C:\\auto\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  logger.info("Launching Browser");
	  
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(GeneralUtils.common_wait, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(GeneralUtils.common_wait,TimeUnit.SECONDS);
	  }
	  else {
		  System.out.println(broswerName);
	  }
	  driver.get(prop.getProperty("url"));
	  logger.info("Entering URL");
	  
	  
  }
  
  public static void commonWaits(WebElement ele) {
	  @SuppressWarnings("deprecation")
	  
	WebDriverWait wait = new WebDriverWait(driver, GeneralUtils.common_wait);
	  
	  wait.until(ExpectedConditions.visibilityOf(ele));
  }
  
  public static void shortSleep() throws InterruptedException {
		 Thread.sleep(2000);
	 }
  
  public static void commonActions(WebElement ele) {
	  commonWaits(ele);
	  Actions act = new Actions(driver);
	  act.moveToElement(ele).click().build().perform();
  }
  
  
  
  public static Object[][] getPatientdetails(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fiss = null;
		try {
			
			fiss = new FileInputStream("C:\\Users\\339154\\Downloads\\auto\\"
					+ "AthmaTesting\\src\\main\\java\\com\\qa\\athma\\testdata\\NewPatients1.xlsx");
			//fiss  = new FileInputStream("C:\\Users\\339154\\Downloads\\NewPatients1.xlsx");
			System.out.println("print : "+fiss.available());
			
			
		}
		catch (FileNotFoundException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fiss);
			
			
		} catch (InvalidFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i<  sheet.getLastRowNum();i++) 
		{
			 for(int j = 0; j < sheet.getRow(0).getLastCellNum();j++) 
			 {
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				 
			 }
		
			
		}
		
		book.close();
		fiss.close();
		return data;
		
		
	}
  
	
	

}
