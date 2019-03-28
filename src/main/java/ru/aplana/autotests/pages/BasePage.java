package ru.aplana.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotests.steps.BaseSteps;

public class BasePage {

    private WebDriver driver = BaseSteps.getDriver();

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public void fillField(WebElement element, String value){
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void scrollPage(String xPath){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xPath)));
    }

    public void scrollPage(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement((By) element));
    }

    public void clickOnElement(WebElement element){
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}