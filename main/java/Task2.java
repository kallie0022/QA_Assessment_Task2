import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {
		//Creates an Instance of Chrome Browser
		WebDriver driver = new ChromeDriver();
	@Test
	public void launchbrowser() {
	
		//Maximize the browser window
	     driver.manage().window().maximize();

}
		
		
	@BeforeMethod
	public void Navigate() {
		 //Navigate to  http://www.way2automation.com
	     driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
	}
	
	@Test
	public void ValidateListTable() {
	// Validates List of Users in the table by verifying url 
		  String URL = driver.getCurrentUrl();
		     Assert.assertEquals(URL, "http://www.way2automation.com/angularjs-protractor/webtables/" );
	}
		
	
	
	@Test
	public void ClickAddUser()
	{
		//Click Add user 
		 driver.findElement(By.cssSelector("body > table > thead > tr:nth-child(2) > td > button")).click();
		  
	}
	
	
	
	     ArrayList<String> FirstName = readExcelData(0);
		 ArrayList<String> LastName = readExcelData(1);
		 ArrayList<String> UserName = readExcelData(2);
		 ArrayList<String> Password = readExcelData(3);
		 ArrayList<String> Customer = readExcelData(4);
		 ArrayList<String> Role = readExcelData(5);
		 ArrayList<String> Email = readExcelData(6);
		 ArrayList<String> Cell = readExcelData(7);
	@Test	 
	public void AddUser() {
		
		//// Add users with the following details:
		 // for loop to loop the users from the excel document into the form 	 
		for(int i=0;i<FirstName.size();i++) {
		//First Name path
		driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")).sendKeys(FirstName.get(i));
	     Thread.sleep(2000);
	     //LastName path
	     driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input")).sendKeys(LastName.get(i));
	     Thread.sleep(2000);
	     //UserName path
	     driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input")).sendKeys(UserName.get(i));
	     Thread.sleep(2000);
	     //Password path
	     driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > input")).sendKeys(Password.get(i));
	     Thread.sleep(2000);
	     //Customer
	     // Handling for radio button selection 
	     // use of 'if' statment 
	     if (Customer.contains("Company AAA")) {
	    	 WebElement RadioButton = (driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > label:nth-child(1)")));
	     RadioButton.click();
	    	 
	     }
	     else { 
	    	 WebElement RadioButton = (driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > label:nth-child(2)")));
		     RadioButton.click();
	     }
	     
	     Thread.sleep(2000);
	     //Roles
	     //handling drop down selection
	     Select objC = new Select(driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(6) > td:nth-child(2) > select")));
	   objC.selectByVisibleText(Role.get(i));
	     
	     Thread.sleep(2000);
	     
	     // Email Addresses 
	     driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input")).sendKeys(Email.get(i));
	     Thread.sleep(2000);
	     //Cellphone Numbers
	     driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(8) > td:nth-child(2) > input")).sendKeys(Cell.get(i));
	     Thread.sleep(2000);	
	     // To save first user data that was automatically inserted within the form 
	     driver.findElement(By.xpath("/html/body/div[3]/div[3]/button[2]")).click();
	     Thread.sleep(6000);
	     // This is to add the second user on to the table 
	    driver.findElement(By.cssSelector("body > table > thead > tr:nth-child(2) > td > button")).click();
	     Thread.sleep(2000);
		 // this will  save the second user  that was automatically inserted within the form 
	     driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-footer > button.btn.btn-success")).click();
	     
	     Thread.sleep(6000);
		 
	     
	}

			   	     return list;
			@Test /// Ensure iteratiztion  in the table and loops users to have a unqiue run 
			public void UniqueUsername(String username) {
				  
				//array to locate the username on the web
				int tr[]= new int [7];
				System.out.println(UserName);
				
				
				//looping the names
				for(int i=1; i<tr.length;i++ ) {
					
					tr[i]=i;
					
					String jk = driver.findElement(By.xpath("/html/body/table/tbody/tr["+tr[i]+"]/td[3]")).getText();
					
					
				if(UserName.contains(jk)) {
					System.out.println("user name is repeated!!");
					break;
					
				}

				}
			  
				System.out.println("user succesful added");

		  }
			
			@Test
		//Prints out Users in console
         // connecting Excel to the form 
		// using a read excel project to connect it to this application 
		// See ExcelRead project for further detail on connecting/Link 
		  public static  ArrayList<String> readExcelData (int colNo) throws IOException {
			   FileInputStream fil = new FileInputStream("C:\\Users\\Reverside\\Desktop\\QA Assesment\\Testdata.xlsx");
		        XSSFWorkbook wb = new XSSFWorkbook(fil);
		        XSSFSheet sheet = wb.getSheet("Test Data");
		        
		        Iterator<Row> rowIterator=sheet.iterator();
			    rowIterator.next();
			    
			    ArrayList<String> list = new ArrayList<String>();
			    while (rowIterator.hasNext()) {
			    	
			    	list.add(rowIterator.next().getCell(colNo).getStringCellValue());
			    }
			    System.out.println("List ::::" +list);
			    	    
		  }
			
			
/// Quiting/ Exciting Application 
	@Test 
	public void quit(){
		
		driver.quit();
	 System.out.println("Quit Browser");
	}

}
