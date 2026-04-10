package add.mini.adv.test;

import org.testng.annotations.Test;

import add.mini.adv.base.BaseTest;
import add.mini.adv.pages.windows_page;

public class WindowsTest extends BaseTest{
	
	@Test
	public void windowTestcase() {
		windows_page wp = new windows_page(getDriver());
		wp.open();
		wp.clickClickHereButton();
		
	}

}
