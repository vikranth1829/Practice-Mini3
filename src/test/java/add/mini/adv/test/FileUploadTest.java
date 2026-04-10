package add.mini.adv.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import add.mini.adv.base.BaseTest;
import add.mini.adv.pages.upload_page;

public class FileUploadTest extends BaseTest{

	@Test
	public void uploadFile() {
		upload_page upfile= new upload_page(getDriver());
		upfile.open();
		upfile.inputFile();
		upfile.clickUploadButton();
		String filelabel = upfile.getUploadedFileLabel();
		Assert.assertEquals(filelabel, "sample.txt");
	}
	
}
