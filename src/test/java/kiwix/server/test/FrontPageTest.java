package kiwix.server.test;

import java.util.List;

import org.kiwix.frontpage.Data_Enum;
import org.kiwix.frontpage.PageObjectFactory;
import org.testng.annotations.Test;

import com.springer.omelet.data.IBrowserConf;
import com.springer.omelet.data.IProperty;
import com.springer.omelet.driver.Driver;
import com.springer.omelet.testng.support.SAssert;

public class FrontPageTest extends BaseServerSetUp {
	SAssert sassert = new SAssert();

	@Test(dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "Data", enabled = true)
	public void verifyCountOfZimFileLoaded(IBrowserConf browserConf,
			IProperty prop) {
		PageObjectFactory pof = new PageObjectFactory(
				Driver.getDriver(browserConf), prop);
		sassert.assertEquals(pof.libraryPage().load().isLoaded()
				.countZimFileLoaded(), "1", "Check for the count of titles");
		sassert.assertAll();
	}

	@Test(dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "Data", enabled = true)
	public void verifyTitleOfZimFiles(IBrowserConf browserConf, IProperty prop) {
		// Only Check if the list have the titles thats it no need to check the
		// count
		
		String title1 = prop.getValue(Data_Enum.LibP_ZimF);
		PageObjectFactory pof = new PageObjectFactory(
				Driver.getDriver(browserConf), prop);
		List<String> returnTitles = pof.libraryPage().load().isLoaded()
				.getZimFileTitles();
		sassert.assertTrue(returnTitles.contains(title1), "Check if title:"
				+ title1 + " is present");
		sassert.assertAll();
	}

	@Test(dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "Data", enabled = true)
	public void verifyDisplayedZimFilesCanBeLoaded(IBrowserConf browserConf,
			IProperty prop) {
		// click on the load button and verify the titles it should contain the
		// text
		PageObjectFactory pof = new PageObjectFactory(
				Driver.getDriver(browserConf), prop);
		int index = 0;
		pof.libraryPage().load().isLoaded().loadZimFile(index);
		String expectedTitle = prop.getValue(Data_Enum.ContP_Title);
		sassert.assertTrue(true, Driver.getDriver().getTitle().toLowerCase());
		sassert.assertTrue(true, expectedTitle.toLowerCase());
		sassert.assertTrue(Driver.getDriver().getTitle().toLowerCase()
				.contains(expectedTitle.toLowerCase()),
				"verify if title of page is: " + expectedTitle);
		sassert.assertAll();
	}

	@Test(dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "Data", enabled = true)
	public void verifyMetaDataOfZimFile(IBrowserConf browserConf, IProperty prop) {
		PageObjectFactory pof = new PageObjectFactory(
				Driver.getDriver(browserConf), prop);
		Integer articlesCount = pof.libraryPage().load().isLoaded().getSize(0);
		pof.libraryPage().loadZimFile(0);
		sassert.assertEquals(pof.contentPage().getTocCount(), articlesCount,
				"Verify meta deta info on Home page for size and toc count on Content Page");
		sassert.assertAll();
	}

}
