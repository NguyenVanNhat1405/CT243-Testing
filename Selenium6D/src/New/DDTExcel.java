package New;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTExcel {
	
	// TODO Auto-generated method stub
	
	
	WebDriver driver;  
	
	 protected static String result;
	
	@Test(dataProvider="testdata")
	public void DemoProject(String username, String password)
	{
		
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\Kiem Thu Tu Dong\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver(); 
			
			driver.get("https://elearning.ctu.edu.vn/login/index.php");
					
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
					
			driver.findElement(By.id("loginbtn")).click(); 
						
					
			Thread.sleep(2000);
					
			//Assert.assertTrue(driver.getTitle().matches("Login: Mercury Tours"), "Invalid credentials");
			Assert.assertEquals(driver.findElement(By.linkText("Trang cá nhân")).getText().toString(), "Trang cá nhân");			
			System.out.println("Login successful");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	void ProgramTermination()
	{
		driver.quit();
	}
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed()
	{
     ReadExcelFile config = new     
          ReadExcelFile("D:\\Kiem Thu Tu Dong\\Tesstdata\\LoginCredentials.xlsx");
		
				
		int rows = config.getRowCount(0);
		
		Object[][] credentials = new Object[rows][2];
		
		for(int i=0; i<rows; i++)
		{
			credentials[i][0] = config.getData(0, i, 0);
			credentials[i][1] = config.getData(0, i, 1);	
		}
		
		return credentials;
	}
}
