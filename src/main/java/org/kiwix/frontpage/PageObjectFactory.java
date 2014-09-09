package org.kiwix.frontpage;

import org.openqa.selenium.WebDriver;

import com.springer.omelet.data.IProperty;

public class PageObjectFactory {

	private WebDriver driver;
	private IProperty prop;
	private LibraryPage libraryPage;
	private ContentPage contentPage;

	public PageObjectFactory(WebDriver driver, IProperty prop) {
		this.driver = driver;
		this.prop = prop;
	}

	public LibraryPage libraryPage() {
		if (libraryPage == null) {
			libraryPage = new LibraryPage(driver, prop);
		}
		return libraryPage;
	}

	public ContentPage contentPage() {
		if (null == contentPage) {
			contentPage = new ContentPage(driver,prop);
		}
		return contentPage;
	}

}
