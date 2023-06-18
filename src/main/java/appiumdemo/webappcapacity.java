package appiumdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class webappcapacity {

	
	public static AndroidDriver<AndroidElement> web_method() throws MalformedURLException
	{
		 DesiredCapabilities dc = new DesiredCapabilities();
	        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "icarus");
	        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	        dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C://Users//knwrp//Downloads//chromedriver_win32 (3)//chromedriver.exe");
	        // chromeoptions---is giving permission to appium to act on chromebrowser
	        dc.setCapability("appium:chromeOptions",ImmutableMap.of("w3c",false));
	        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		    return driver;
	}
}
