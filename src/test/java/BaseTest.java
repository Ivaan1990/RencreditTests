import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.aplana.autotests.steps.BaseSteps;
import ru.aplana.autotests.steps.DepositSteps;
import ru.aplana.autotests.steps.MainSteps;

public class BaseTest extends BaseSteps {

    @Test
    @DisplayName("Оформление вклада")
    public void testMethod(){
        MainSteps mainSteps = new MainSteps();
        DepositSteps depositSteps = new DepositSteps();
        mainSteps.stepGoToCalculator();
        depositSteps.checkTheTitle("Рассчитайте доходность по вкладу");
        depositSteps.choiseTheValute("евро");
        depositSteps.salaryDeposit("50000");
        //depositSteps.termDeposit(9);
        depositSteps.everyMonthPayment("1000");
        depositSteps.checkBoxCapitalizationON();
    }
}