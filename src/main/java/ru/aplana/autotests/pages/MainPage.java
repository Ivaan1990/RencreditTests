package ru.aplana.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'service')]/div[contains(text(),'Вклады')]/../..//span[contains(text(),'Калькулятор')]")
    public WebElement depositCalculator;
}