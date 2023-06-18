package appiumdemotest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appiumdemo.capabitity;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.time.Duration;
import static java.time.Duration.ofSeconds;

public class demo_native extends capabitity {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void set_up() throws MalformedURLException {
		driver = test();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(enabled = false)
	public void Tc1() throws InterruptedException {
		System.out.println("Im in the nativeapp");

		/*
		 * driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();
		 * Thread.sleep(5000); driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 * driver.findElement(MobileBy.AccessibilityId("Animation")).click();
		 * Thread.sleep(5000); driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 * driver.findElement(MobileBy.AccessibilityId("App")).click();
		 * Thread.sleep(5000); driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 * driver.findElement(MobileBy.AccessibilityId("Content")).click();
		 */
		// Thread.sleep(5000);
		/* driver.pressKey(new KeyEvent(AndroidKey.BACK)); */
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("android:id/edit")).sendKeys("test");
		Thread.sleep(3000);
		driver.hideKeyboard();
		// driver.findElement(By.xpath("//*[@text='OK']")).click();
		// IF u are using android ui automator -used in hybrid app, native app
		// ui automator can be used only for web application
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"OK\")")).click();
		Thread.sleep(3000);

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	@Test(enabled = false)
	public void notifications() throws InterruptedException {
		driver.openNotifications();
		Thread.sleep(3000);
		driver.findElements(By.className("android.widget.ImageView")).get(0).click();

	}

	@Test(enabled = false)
	public void scroll() throws InterruptedException {

		// driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		// if you have to scroll then u need three things---ui automator,ui selector,ui
		// scrollable,scroll intoview
		Thread.sleep(4000);
		// driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		// AndroidElement ele=driver.findElementByAndroidUIAutomator("new
		// UiSelector().clickable(true)");
		// Dimension count=ele.getSize();
		// System.out.println(count);
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		Thread.sleep(4000);
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		TouchAction taction = new TouchAction(driver);
		AndroidElement lp = driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
		Thread.sleep(4000);

		// taction.longPress(LongPressOptions().withElement(element(lp)).withDuration(ofSeco))
		taction.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();

	}

	@Test(enabled = false)
	public void swipActions() throws Exception {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		Thread.sleep(3000);

		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		TouchAction taction = new TouchAction(driver);

		AndroidElement drag = driver.findElement(MobileBy.AccessibilityId("12"));
		AndroidElement drop = driver.findElement(MobileBy.AccessibilityId("3"));
		Thread.sleep(3000);

		taction.longPress(longPressOptions().withElement(element(drag)).withDuration(ofSeconds(5)))
				.moveTo(element(drop)).release().perform();

	}

	@Test(enabled = false)
	public void dragAnddrop() throws Exception {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		AndroidElement drag = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement drop = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		TouchAction tactions = new TouchAction(driver);
		tactions.longPress(longPressOptions().withElement(element(drag)).withDuration(ofSeconds(5)))
				.moveTo(element(drop)).release().perform();

	}

	@Test
	public void switching_window() throws Exception {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		Thread.sleep(3000);

		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();

		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650)555-1212");
		Thread.sleep(3000);
		driver.hideKeyboard();

		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("123");
		Thread.sleep(3000);

		driver.findElement(MobileBy.AccessibilityId("Send")).click();
		Thread.sleep(3000);
		driver.activateApp("com.google.android.apps.messaging");
		Thread.sleep(3000);

		String mesg = driver.findElement(By.xpath("//*[@text='You: 123']")).getText();
		System.out.println(mesg);
		Thread.sleep(7000);
		driver.activateApp("io.appium.android.apis");

	}

}