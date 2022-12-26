package util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import base.BasePage;

public class WebEventListener extends BasePage implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {

		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		if (element == null) {
			System.out.println("Just before finding element: " + by.toString() + " on browser: " + driver.toString() );

		} else {
			System.out.println("Just before finding element: " + by.toString() + " inside " + element.toString() + " Web element on browser: " + driver.toString() );
		}
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		if (element == null) {
			System.out.println("Just after finding element: " + by.toString() + " on browser: " + driver.toString() );

		} else {
			System.out.println("Just after finding element: " + by.toString() + " inside " + element.toString() + " Web element on browser: " + driver.toString() );
		}
	}


	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Before running script :");
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("After running script :");
	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before Alert Accept");
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Alert Accept");

	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("After Alert Dismiss");

	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before Alert Dismiss");

	}

	public void beforeNavigateRefresh(WebDriver driver) {

		System.out.println("Before afterNavigateRefresh");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("After afterNavigateRefresh");

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Before changing value of: "+ element.toString());

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("After changing value of : "+ element.toString());

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		System.out.println("After getting screenshot: "+ arg1.toString());
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		System.out.println("After getting text: "+ arg2);

	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("After switching to window : "+ arg0.toString());

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		System.out.println("Before getting screnshot: "+ arg0.toString());

	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {

		System.out.println("Before getting text: "+ arg0.toString());

	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("Before switching to window: "+arg0);
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception Occurred" + error);

		try {
			TestUtils.takeScreenShot();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
