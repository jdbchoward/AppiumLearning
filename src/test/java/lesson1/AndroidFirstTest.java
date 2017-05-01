package lesson1;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class AndroidFirstTest {
  @Test
  public void f() throws MalformedURLException, InterruptedException {
	  AppiumDriver driver;
//	  File app=new File("D:\\weixin_1041.apk");
	  DesiredCapabilities capabilities=new DesiredCapabilities();
	  //if app already installed then dont need this 
//	  capabilities.setCapability("app", app.getAbsolutePath());
	  capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
	  //deviceName could be anything
	  capabilities.setCapability("deviceName", "0597ba84");
	  capabilities.setCapability("platformVersion", "6.0");	  
	  
	  capabilities.setCapability("appPackage", "com.tencent.mm");
	  capabilities.setCapability("appActivity", ".ui.LauncherUI");
	  //chinese input, reset after running
	  capabilities.setCapability("unicodeKeyboard", "True");
	  capabilities.setCapability("resetKeyboard", "True");
	  //dont sign if we need to install app
	  capabilities.setCapability("noSign", "True");
	  
	  driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	  Thread.sleep(5000);
	  try{
		  login(driver);
		  Thread.sleep(5000);
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }finally{
		  Thread.sleep(3000);
		  driver.quit();
	  }
	  
  }
  
  public void login(AppiumDriver driver)
  {
	  driver.findElementByName("Allow").click();
	  waiting(2000);
	  driver.findElementByName("Allow").click();
	  waiting(2000);
	  driver.findElementByName("Allow").click();
	  waiting(2000);
	  driver.findElementById("com.tencent.mm:id/cdi").click();
	  
	  driver.findElementById("com.tencent.mm:id/bdr").click();
	  driver.findElementByXPath("//android.widget.LinearLayout[@resource-id='com.tencent.mm:id/bd2']/android.widget.EditText").sendKeys("12345");
	  driver.findElementByXPath("//android.widget.LinearLayout[@resource-id='com.tencent.mm:id/bd3']/android.widget.EditText").sendKeys("12345");
	  driver.findElementById("com.tencent.mm:id/bd4").click();
  }
  
  
  public void waiting(int waitTime)
  {
	  try {
		Thread.sleep(waitTime);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
