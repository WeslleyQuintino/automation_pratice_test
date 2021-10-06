package pages;

import Core.DriverFactory;
import beans.ValuesHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Core.DriverFactory.getDriver;

public class BasePage {

	private ValuesHelper helper = new ValuesHelper();

	@FindBy(xpath = "//img[contains(@class, 'logo')]")
	private WebElement logo;

	public void selectWithValue(WebElement elemento, String valor) {
		Select selectDateDays = new Select(elemento);
		selectDateDays.selectByValue(valor);
	}

	public void selectWithText(WebElement elemento, String texto) {
		Select selectDateDays = new Select(elemento);
		selectDateDays.selectByVisibleText(texto);
		;
	}

	public void selectFirst(WebElement elemento) {
		Select select = new Select(elemento);
		select.selectByIndex(0);
	}

	public void backToHome() {
		logo.click();
	}

	public void sleep(int milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void selectPerText(WebElement elemento, String texto) {
		Select selectDateDays = new Select(elemento);
		selectDateDays.selectByVisibleText(texto);;
	}
	
	public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,285)");
    }
	
	public void takeScreenshot(String screenshot){
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH");
			File srcFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			String scenarioName = helper.getScenarioName();
				FileUtils.copyFile(srcFile, new File(
						"Evidence\\" + sdf.format(date) + "\\" + scenarioName + "\\" + screenshot + ".png"));
		} 
		catch (Exception e) {
			
		}

	}
}
