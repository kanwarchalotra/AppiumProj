package appiumwebtest;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appiumdemo.webappcapacity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class webapp_test extends webappcapacity{

	AndroidDriver<AndroidElement> driver;
	
	
@BeforeTest
public void setup() throws MalformedURLException
{
	driver=web_method();
	// go to platform tools path- and check for devices are connected or not- adb devices
}
	

@Test(priority = 0)
public void test1() throws Exception
{
	//chrome://inspect/#devices need to open browser in laptop chrome
	

	
	
	  System.out.println("webapp"); Thread.sleep(8000);
	  driver.get("https://www.google.com/");
	  driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("moolya");
		
		  Actions act=new Actions(driver); act.sendKeys(Keys.ENTER).build().perform();
		
		  /* List<AndroidElement> values =driver.findElements(By.tagName("a"));
		 * 
		 * System.out.println(values.size()); for(AndroidElement e:values) {
		 * System.out.println(e.getAttribute("href")); System.out.println(e.getText());
		 */
	  
	 
	Thread.sleep(4000);
	AndroidElement element = driver.findElement(By.xpath("//*[text()='Moolya Software Testing Salaries in India']"));

	// Use JavaScriptExecutor to scroll to the element
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", element);
	System.out.println(driver.getTitle());
	Thread.sleep(6000);
act.click(element).build().perform();

}





}
