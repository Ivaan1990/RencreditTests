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

    @FindBy(xpath = "//div[@class=\"jq-selectbox__select\"]")
    public WebElement term;

    @FindBy(xpath = "//*[@name='replenish']")
    public WebElement everyMonthPay;

    @FindBy (xpath = "//span[contains(text(), 'Ежемесячная капитализация')]/../../span")
    public WebElement everyMonthCapitalization;

    @FindBy (xpath = "//span[contains(text(), 'Частичное снятие')]/../../span//div")
    public WebElement withdrawalPartial;

}
