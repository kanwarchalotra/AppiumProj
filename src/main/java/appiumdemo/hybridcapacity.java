package appiumdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class hybridcapacity {
	
	public static AndroidDriver<AndroidElement> hybrid() throws MalformedURLException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
	    dc.setCapability(MobileCapabilityType.DEVICE_NAME, "icarus");
	    dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
	    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
	    dc.setCapability(MobileCapabilityType.NO_RESET, false);
	    // automation name for android is android ui automator (in built feature of android used to find the element)        
	    dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
	    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
	    return driver;
	}
	

}
