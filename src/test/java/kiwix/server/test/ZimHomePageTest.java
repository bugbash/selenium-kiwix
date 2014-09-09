package kiwix.server.test;

import java.util.List;
import java.util.UUID;

import org.kiwix.frontpage.Data_Enum;
import org.kiwix.frontpage.PageObjectFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.springer.omelet.data.IBrowserConf;
import com.springer.omelet.data.IProperty;
import com.springer.omelet.driver.Driver;
import com.springer.omelet.testng.support.SAssert;

public class ZimHomePageTest extends BaseServerSetUp {
	
	SAssert sassert = new SAssert();
	
	@Test(dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "Data", enabled = true)
	public void verifyHomeButtonIsWorkingFine(IBrowserConf browserConf,IProperty prop){
		PageObjectFactory pof = new PageObjectFactory(Driver.getDriver(browserConf),prop);
		pof.libraryPage().load().isLoaded().loadZimFile(0);
		pof.contentPage().clickHomePageButton();
		sassert.assertEquals(Driver.getDriver().getTitle(),prop.getValue(Data_Enum.ContP_Title),"Verify on Clicking home button Content page doesnot do anything neither changes title");
		sassert.assertAll();
	}
	@Test(dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "Data", enabled = true)
	public void verifyLibraryButtonIsWorkingFine(IBrowserConf browserConf,IProperty prop){
		PageObjectFactory pof = new PageObjectFactory(Driver.getDriver(browserConf), prop);
		pof.libraryPage().load().isLoaded().loadZimFile(0);
		pof.contentPage().isLoaded().clickLibraryButton();
		//check if library page is loaded
		sassert.assertTrue(pof.libraryPage().isLoaded() != null,"verify clicking on library button your direct to library page");
		sassert.assertAll();
	}
	
	@Test(dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "Data", enabled = true)
	public void verifyAutoCompleteSearchWorks(IBrowserConf browserConf,IProperty prop){
		PageObjectFactory pof = new PageObjectFactory(Driver.getDriver(browserConf), prop);
		pof.libraryPage().load().isLoaded().loadZimFile(0);;
		List<WebElement> searchResult = pof.contentPage().verifyAjaxSearchResult("Ray");
		sassert.assertTrue(searchResult != null,"Search Results are visible");
		sassert.assertTrue(searchResult.size()>1,"Count of Search Result is greater than 1 , that mean some results are returned");
		sassert.assertAll();
	}
	@Test(dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "Data", enabled = true)
	public void verifyIfAutoComplete_Says_NoResultFound_When_NothingPresent(IBrowserConf browserConf,IProperty prop){
		PageObjectFactory pof = new PageObjectFactory(Driver.getDriver(browserConf), prop);
		pof.libraryPage().load().isLoaded().loadZimFile(0);;
		String randomSearchString = UUID.randomUUID().toString();
		List<WebElement> searchResult = pof.contentPage().verifyAjaxSearchResult(randomSearchString);
		sassert.assertTrue(searchResult.get(0).getText().contains("containing"),"Search Results are visible but only containg ... is shown");
		sassert.assertEquals(searchResult.size(),1,"Count of Search Result");
		pof.contentPage().clickSearchButton();
		//sassert.assertTrue(Driver.getDriver().getTitle().equalsIgnoreCase("Search:"),"Check title is Search:");
		sassert.assertEquals(pof.contentPage().getHeaderErrText(),prop.getValue(Data_Enum.ContP_ErrMess)+" "+randomSearchString,"Check Error message returned");
		
		sassert.assertAll();
	}
	@Test(dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "Data", enabled = true)
	public void verifyClickOnAutoCompleteSearchWorks(IBrowserConf browserConf,IProperty prop){
		PageObjectFactory pof = new PageObjectFactory(Driver.getDriver(browserConf), prop);
		pof.libraryPage().load().isLoaded().loadZimFile(0);;
		int index = 1;
		List<WebElement> searchResult = pof.contentPage().verifyAjaxSearchResult("Ray");
		String expectedTitle = searchResult.get(index).getText();
		sassert.assertEquals(pof.contentPage().getTitleAfterClickingOnSearchResult(index), expectedTitle,"Title Should be same as Search Result returned");
		sassert.assertAll();
	}
	
	public void verifyTableOfContentsLinkWorks(){
		
	}
	
	public void verifyCountOfTableContentIsSameOnHomePage(){
		
	}

}
