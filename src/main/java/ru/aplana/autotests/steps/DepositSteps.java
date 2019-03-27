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

    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 10,1000);
    private DepositPage depositPage = new DepositPage();

    @Step("Проверка заголовка страницы 'Рассчитайте доходность по вкладу'")
    public void checkTheTitle(String title){
        Assert.assertEquals("Надпись не совпадает", title, depositPage.title.getText());
    }

    @Step("Выбираем валюту вклада")
    public void choiseTheValute(String valute){
        switch (valute.toLowerCase()){
            case "евро":
                depositPage.valuteUSD.click();
                break;
            case "рубли":
                depositPage.valuteRub.click();
                break;
        }

    }

    @Step("Вводим сумму вклада")
    public void salaryDeposit(String amount){
        depositPage.amount.click();
        depositPage.fillField(depositPage.amount, amount);
        depositPage.scrollPage("//*[@name='amount']");
    }

    @Step("Выбираем срок вклада")
    public void termDeposit(int term){
        /*wait.until(ExpectedConditions.visibilityOf(
                BaseSteps.getDriver().findElement(By.xpath("//*[@class='jq-selectbox__select']"))));*/
        //depositPage.term.click();
        for(WebElement element : depositPage.listOfTerms){
            System.out.println(element.getText());
        }
    }

    @Step("Вносим сумму ежемесячного пополнения вклада")
    public void everyMonthPayment(String pay){
        depositPage.evereMonthPay.click();
        depositPage.fillField(depositPage.evereMonthPay, pay);
    }

    @Step("Ставим чекбокс на ежемесячной капитализации")
    public void checkBoxCapitalizationON(){
        depositPage.everyMonthCapitalization.click();
    }
}