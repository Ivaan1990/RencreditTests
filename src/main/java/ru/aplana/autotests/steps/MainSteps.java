package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.MainPage;

public class MainSteps {
    MainPage mainPage = new MainPage();

    @Step("Выполняем переход в калькулятор вклада")
    public void stepGoToCalculator(){
        mainPage.depositCalculator.click();
    }
}
