package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotests.pages.BasePage;
import ru.aplana.autotests.pages.DepositPage;

import java.util.concurrent.TimeUnit;

public class DepositSteps {

    private static Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30,1000);
    private DepositPage depositPage = new DepositPage();

    @Step("Проверка заголовка страницы 'Рассчитайте доходность по вкладу'")
    public void checkTheTitle(String title){
        Assert.assertEquals("Надпись не совпадает", title, depositPage.title.getText());
    }

    @Step("Выбираем валюту вклада - {0}")
    public void choiseTheValute(String valute){
        switch (valute.toLowerCase().trim()){
            case "евро":
                depositPage.clickOnElement(depositPage.valuteUSD);
                break;
            case "рубли":
                depositPage.valuteRub.click();
                break;
        }
    }

    @Step("Вводим сумму вклада - {0}")
    public void salaryDeposit(String amount){
        depositPage.amount.click();
        depositPage.fillField(depositPage.amount, amount);
        depositPage.scrollPage("//*[@name='amount']");
    }

    @Step("Выбираем срок вклада - {0}")
    public void termDeposit(String value){
        depositPage.term.click();
        wait.until(ExpectedConditions.elementToBeClickable(depositPage.term));
        Select select = new Select(BaseSteps.getDriver().findElement(By.xpath("//select[@class='calculator__slide-input js-slide-value']")));
        wait.until(ExpectedConditions.visibilityOf(BaseSteps.getDriver().findElement(By.xpath("//div[@class=\"jq-selectbox__select\"]"))));
        select.selectByVisibleText(value);
    }

    @Step("Вносим сумму ежемесячного пополнения вклада - {0}")
    public void everyMonthPayment(String pay){
        depositPage.everyMonthPay.click();
        depositPage.fillField(depositPage.everyMonthPay, pay);
    }

    @Step("Ставим чекбокс на ежемесячной капитализации - {0}")
    public void checkBoxCapitalization(boolean capitalization){
        if(capitalization){
            depositPage.everyMonthCapitalization.click();
        }
    }

    @Step("Ставим чекбокс на частичное снятие  - {0}")
    public void checkBoxPartialDraw(boolean flag){
        if(flag){
            depositPage.withdrawalPartial.click();
        }
    }

    @Step("Проверка автоматически заполненных полей")
    public void checksTheFields(String valute){
        String rate, accrual, refill;
        depositPage.scrollPage("//*[@class=\"calculator-block__title block-title\"]");
        wait.until(ExpectedConditions.visibilityOf(depositPage.refill));

        switch (valute){
            case "евро":
                rate = depositPage.rate.getText().replace("%","");
                accrual = depositPage.accrual.getText();
                refill = depositPage.refill.getText().replace(" ","");
                Assert.assertEquals("Ставка не совпадает с требуемой","0.75", rate);
                Assert.assertEquals("Сумма начислений не совпадает с требуемой","301,42", accrual);
                Assert.assertEquals("Сумма пополнение за 6 месяцев не совпадает с требуемой","8000", refill);
                break;
            case "рубли":
                rate = depositPage.rate.getText().replace("%","");
                accrual = depositPage.accrual.getText();
                refill = depositPage.refill.getText().replace(" ","");
                Assert.assertEquals("Ставка не совпадает с требуемой","6.25", rate);
                Assert.assertEquals("Сумма начислений не совпадает с требуемой","65132,87", accrual);
                Assert.assertEquals("Сумма пополнение за 6 месяцев не совпадает с требуемой","150000", refill);
                break;
        }

    }
}