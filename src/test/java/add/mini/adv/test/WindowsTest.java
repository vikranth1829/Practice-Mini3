package add.mini.adv.test;


import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import add.mini.adv.base.BaseTest;
import add.mini.adv.pages.windows_page;


public class WindowsTest extends BaseTest{
	
	@Test
	public void windowTestcase() {
		windows_page wp = new windows_page(getDriver());
		wp.open();
		wp.clickClickHereButton();
		
		String parentwindow = getDriver().getWindowHandle();
		wp.clickClickHereButton();
		
		Set<String> allhandle = getDriver().getWindowHandles();
		
		for(String handle : allhandle) {
		if(!handle.equals(parentwindow)) {
			getDriver().switchTo().window(handle);
			break;
			}
		}
		String childWindowName = wp.getCurrentWindowTitle();
		Assert.assertEquals(childWindowName, "New Window");
		getDriver().close();
		wp.switchBackToMainWindow(parentwindow);
		
	}

}
