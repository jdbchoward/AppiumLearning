package pages;

import io.appium.java_client.AppiumDriver;

public class GroupOnDetailPage extends PageBase{
	
	public AppiumDriver driver;
	//����ϲ��
	public String buy = "com.sankuai.meituan:id/buy";
		
	public GroupOnDetailPage(AppiumDriver driver){
		this.driver = driver;
	}

}
