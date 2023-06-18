package appiumhybriddemo;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appiumdemo.hybridcapacity;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class demo_hybrid extends hybridcapacity {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		driver = hybrid();
	}

	@Test(priority = 0)
	public void test1() throws Exception {
		System.out.println("hybrid");
		Thread.sleep(4000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		// Anguilla
		Thread.sleep(4000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"))");
		Thread.sleep(3000);
		// Anguilla
		driver.findElement(MobileBy.xpath("//*[@text='Belgium']")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("john doe");
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	}

	@Test(priority = 1)
	public void test2() throws Exception {

		Thread.sleep(5000);
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(3000);
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();

		Thread.sleep(8000);
		/*
		 * driver.findElementByAndroidUIAutomator(
		 * "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"))"
		 * ); Thread.sleep(10000); //
		 * driver.findElementByAndroidUIAutomator("text(\"ADD TO CART\")").click();
		 * driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(2).click(
		 * );
		 */
		Thread.sleep(5000);

		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		/*
		 * String productname =
		 * driver.findElementByAndroidUIAutomator("text(\"Air Jordan 4 Retro\")").
		 * getText(); System.out.println(productname); Thread.sleep(3000);
		 * 
		 * String productname1 =
		 * driver.findElementByAndroidUIAutomator("text(\"Air Jordan 1 Mid SE\")").
		 * getText(); Thread.sleep(5000); System.out.println(productname1);
		 * driver.findElementByAndroidUIAutomator(
		 * "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"))"
		 * ); Thread.sleep(5000); String productname2 =
		 * driver.findElementByAndroidUIAutomator("text(\"Nike SFB Jungle\")").getText()
		 * ; Thread.sleep(2000); System.out.println(productname2);
		 */
		String price = driver.findElementByAndroidUIAutomator("text(\"$160.97\")").getText();
		Thread.sleep(2000);
		price=price.substring(1);
		System.out.println(price);
		double p=Double.parseDouble(price);
		String price1 = driver.findElementByAndroidUIAutomator("text(\"$120.0\")").getText();
		Thread.sleep(2000);
		price1=price1.substring(1); //$120.00
		System.out.println(price1);
		double p1=Double.parseDouble(price1);
        
		double sumup=p+p1;
Thread.sleep(6000);
		String totalPrice=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		totalPrice=totalPrice.substring(2);
		System.out.println(totalPrice);
		double pr=Double.parseDouble(totalPrice);
		if(pr==sumup)
		{
			System.out.println("cost is matching");
		}else
		{
			System.out.println("cost is not matching");
		}
		
		/*
		 * driver.
		 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"))"
		 * ); Thread.sleep(5000); String price2 =
		 * driver.findElementByAndroidUIAutomator("text(\"$116.97\")").getText();
		 */
		//System.out.println(price2);

	}

	@Test(priority = 2)
	public void test3() throws Exception
	{
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}
	
	
}
