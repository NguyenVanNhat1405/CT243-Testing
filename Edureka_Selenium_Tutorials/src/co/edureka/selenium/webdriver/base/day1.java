package co.edureka.selenium.webdriver.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class day1 {
	JavascriptExecutor jse;
	WebDriver driver;
	public void web() {
	
			try {
				System.setProperty("webdriver.chrome.driver","D:\\Kiem Thu Tu Dong\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("http://www.edureka.co");
				event();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void event() {
		driver.findElement(By.className("open_search_overlay")).click();
		driver.findElement(By.id("search-input")).sendKeys("java");
		driver.findElement(By.id("search-input")).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(2000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1500)");
		driver.findElement(By.xpath("//*[@id=\'add-master-courses\']/a[11]/div[1]/div[2]/div[1]/div[1]/h3")).click();
		}
	public static void main(String[] args) {
		day1 d = new day1();
		d.web();
				
		

	}

}
