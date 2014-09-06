package org.kiwix.frontpage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.springer.omelet.common.ExpectedConditionExtended;
import com.springer.omelet.common.Utils;
import com.springer.omelet.data.IProperty;
import com.springer.omelet.driver.DriverUtility;
import com.springer.omelet.exception.FrameworkException;

/***
 * Not able to find any useful name
 * 
 * @author kapil
 * 
 */
public class LibraryPage {
	private WebDriver driver;
	private IProperty prop;
	@FindBy(id = "accordion")
	private WebElement zimDivs;
	@FindBys(@FindBy(css = "#accordion a"))
	private List<WebElement> zimFiles;
	@FindBys(@FindBy(css = ".ui-accordion-content.ui-helper-reset.ui-widget-content.ui-corner-bottom"))
	private List<WebElement> zimTitleTable;
	@FindBys(@FindBy(css = "table table tbody tr td"))
	private List<WebElement> metaData;
	private List<String> zimTitles;

	public LibraryPage(WebDriver driver,IProperty prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	public LibraryPage load() {
		driver.get(prop.getValue(Data_Enum.LibP_Url));
		return this;
	}

	public LibraryPage isLoaded() {
		if (null == DriverUtility.waitFor(
				ExpectedConditionExtended.elementsToBeClickable(zimDivs),
				driver, 10)) {
			throw new FrameworkException(
					"Kiwi library page is not loade in 10 seconds");
		}
		//create a titles list
		zimTitles = new ArrayList<String>();
		for (WebElement title : zimFiles) {
			zimTitles.add(title.getText());
		}
		return this;
	}

	public Integer countZimFileLoaded() {
		return zimFiles.size();
	}

	public List<String> getZimFileTitles() {
			return zimTitles;
	}


	/*private void expandZimTable(String titleName) {
		for (WebElement file : zimFiles) {
			titleName.equals(file.getText());
			file.click();
			;
		}
		throw new FrameworkException("Not able to find Zim heaer with name:"
				+ titleName);
	}*/
	
	private void expandZimFileTable(int index){
		if (null != DriverUtility.waitFor(ExpectedConditionExtended
				.invisibilityOfElementLocated(zimTitleTable.get(index)),
				driver, 3)) {
			zimFiles.get(index).click();
		}
	}

	public void loadZimFile(String titleOfZimFile) {

	}

	public void loadZimFile(int index) {
		// create mapping
		expandZimFileTable(index);
		// Now the required table is expanded
		// lets load it
		DriverUtility.waitFor(
				ExpectedConditions.elementToBeClickable(zimTitleTable
						.get(index).findElement(By.cssSelector("button"))),
				driver, 10).click();

	}
	
	public Integer getSize(int index){
		return Integer.valueOf(Utils.getIntegerListFromString(metaData.get(0).getText()).get(2));
	}

}
