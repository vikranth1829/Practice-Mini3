package add.mini.adv.test;

import org.testng.annotations.Test;

import add.mini.adv.base.BaseTest;
import add.mini.adv.pages.iframe_page;

public class IFrameTest extends BaseTest {

	@Test
	public void iFrameTestcase() {
		iframe_page ifpage = new iframe_page(getDriver());
		ifpage.open();
		ifpage.switchtoEditorFrame();
		ifpage.clearEditor();
		ifpage.typeEditor("Hello Selenium");
		ifpage.switchToDefault();
	}

}
