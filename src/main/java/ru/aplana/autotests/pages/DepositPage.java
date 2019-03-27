package ru.aplana.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositPage extends BasePage {

    @FindBy(xpath = "//*[@class=\"calculator-block__title block-title\"]")
    public WebElement title;

    @FindBy(xpath = "//*[contains(@class, 'calculator__currency-field-btn')]/./../..//span[contains(text(),'Доллары США')]")
    public WebElement valuteUSD;

    @FindBy(xpath = "//*[contains(@class, 'calculator__currency-field-btn')]/./../..//span[contains(text(),'Рубли')]")
    public WebElement valuteRub;

    @FindBy(xpath = "//*[@name='amount']")
    public WebElement amount;

    @FindBy(xpath = "//*[@class='jq-selectbox__select']")
    public WebElement term;

    @FindBy(xpath = "//div[@class='jq-selectbox__dropdown']/ul/li")
    public List<WebElement> listOfTerms;

    @FindBy(xpath = "//*[@name='replenish']")
    public WebElement evereMonthPay;

    @FindBy (xpath = "//span[contains(text(), 'Ежемесячная капитализация')]/../../span")
    public WebElement everyMonthCapitalization;
}
