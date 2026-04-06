package add.mini.adv.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import add.mini.adv.base.BaseTest;
import add.mini.adv.pages.Javascript_alert_page;

public class AlertTest extends BaseTest{

	@Test
	public void jsAlertTest() {
		Javascript_alert_page aalert = new Javascript_alert_page(getDriver());
		aalert.open();
		aalert.clickJSAlert();
		aalert.switchToAlert();
		String alertText=aalert.getAlertText();
		aalert.acceptAlert();
		Assert.assertEquals(alertText, "I am a JS Alert");
	}
	
	@Test
	public void jsConfirmAlertTest() {
		Javascript_alert_page jsalert = new Javascript_alert_page(getDriver());
		jsalert.open();
		jsalert.clickJSConfirm();
		jsalert.switchToAlert();
		String alertText=jsalert.getAlertText();
		jsalert.acceptAlert();
		Assert.assertEquals(alertText, "I am a JS Confirm");
	}
	@Test
	public void jsPromptAlertTest() {
		Javascript_alert_page jspromptalert = new Javascript_alert_page(getDriver());
		jspromptalert.open();
		jspromptalert.clickJSPrompt();
		jspromptalert.switchToAlert();
		String msg= "Test Message !";
		jspromptalert.sendTextToAlert(msg);
		jspromptalert.acceptAlert();
		String actualText=jspromptalert.getResultText();
		Assert.assertEquals(actualText, msg);
	}
}