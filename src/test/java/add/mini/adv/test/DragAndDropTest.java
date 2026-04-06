package add.mini.adv.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import add.mini.adv.base.BaseTest;
import add.mini.adv.pages.Drag_and_drop_page;

public class DragAndDropTest extends BaseTest{
	
	@Test
	public void dragAndDrop() {
		Drag_and_drop_page dd = new Drag_and_drop_page(getDriver());
		dd.open();
		Boolean b=dd.dragAtoB();
		Assert.assertTrue(b);
	}

}
