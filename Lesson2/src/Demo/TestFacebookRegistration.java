package Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TestFacebookRegistration {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\Kiem Thu Tu Dong\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://vi-vn.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Tạo tài khoản mới")).click();
		driver.findElement(By.name("lastname")).sendKeys("Nguyen");
		driver.findElement(By.name("firstname")).sendKeys("Nhat");
		driver.findElement(By.name("reg_email__")).sendKeys("Nhat@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("Nhat@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Nhat123");
		
		List <WebElement> gender = driver.findElements(By.name("sex"));
		gender.get(0).click();
		
		Select sel1 = new Select(driver.findElement(By.id("day")));
		sel1.selectByIndex(13);
		Select sel2 = new Select(driver.findElement(By.id("month")));
		sel2.selectByIndex(4);
		Select sel3 = new Select(driver.findElement(By.id("year")));
		sel3.selectByValue("2002");
		
//		driver.findElement(By.name("websubmit")).click();
		
		driver.findElement(By.linkText("Tìm hiểu thêm")).click();
//		driver.navigate().back();
		driver.quit();

	}

}
