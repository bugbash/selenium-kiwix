package org.kiwix.frontpage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.springer.omelet.common.ExpectedConditionExtended;
import com.springer.omelet.data.IProperty;
import com.springer.omelet.driver.Driver;
import com.springer.omelet.driver.DriverUtility;
import com.springer.omelet.exception.FrameworkException;

public class ContentPage {
	
	private WebDriver driver;
	private IProperty prop;
	@FindBy(id = "kiwixhome")
	private WebElement homeButton;
	@FindBy(id = "kiwixlibrary")
	private WebElement libraryButton;
	@FindBys(@FindBy(css = "#content ul li"))
	private List<WebElement> toc;
	@FindBy(id="kiwixsearch")
	private WebElement searchButton;
	@FindBy(id="kiwixsearchbox")
	private WebElement searchBox;
	@FindBys(@FindBy(css = ".ui-autocomplete.ui-menu.ui-widget.ui-widget-content li"))
	private List<WebElement> ajaxSearchResults;
	@FindBy(css = ".header")
	private WebElement headerErr;
	
	public ContentPage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
	
	public ContentPage isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementsToBeClickable(homeButton), driver, 5)){
			throw new FrameworkException("Content Page is not Loaded in 5 seconds");
		}
		return this;
	}
	
	public Integer getTocCount(){
		return toc.size();
	}
	
	public ContentPage clickHomePageButton(){
		homeButton.click();
		return this;
	}
	
	public ContentPage clickLibraryButton(){
		libraryButton.click();
		return this;
	}
	
	public ContentPage clickSearchButton(){
		searchButton.click();
		return this;
	}
	
	public List<WebElement> verifyAjaxSearchResult(String searchText){
		searchBox.sendKeys(searchText);
		if (null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(ajaxSearchResults), driver, 5)){
			return null;
		}
		return ajaxSearchResults;
	}
	
	public String getTitleAfterClickingOnSearchResult(int indexToClick){
		if(ajaxSearchResults.size() < indexToClick){
			throw new FrameworkException("Search Results are less than indexToClick Number");
		}
		//Click on search
		clickSearchButton();
		return driver.getTitle();
	}
	
	public String getHeaderErrText(){
		return headerErr.getText();
	}
	

}
