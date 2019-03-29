import edu.emory.mathcs.backport.java.util.Arrays;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.aplana.autotests.steps.BaseSteps;
import ru.aplana.autotests.steps.DepositSteps;
import ru.aplana.autotests.steps.MainSteps;
import java.util.Collection;


@RunWith(Parameterized.class)
public class BaseTest extends BaseSteps {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"евро", "50000", "9 месяцев","1000", true, false},
                {"рубли", "2000000","6 месяцев" ,"30000", true, true}
        });
    }

    @Parameterized.Parameter
    public String valute;

    @Parameterized.Parameter(1)
    public String firstDeposit;

    @Parameterized.Parameter(2)
    public String term;

    @Parameterized.Parameter(3)
    public String everyMonthPay;

    @Parameterized.Parameter(4)
    public boolean capitalization;

    @Parameterized.Parameter(5)
    public boolean withdrawalPartial;

    @Test
    @DisplayName("Оформление вклада ")
    public void testEUR(){
        MainSteps mainSteps = new MainSteps();
        DepositSteps depositSteps = new DepositSteps();
        mainSteps.stepGoToCalculator();
        depositSteps.checkTheTitle("Рассчитайте доходность по вкладу");
        depositSteps.choiseTheValute(valute);
        depositSteps.salaryDeposit(firstDeposit);
        depositSteps.termDeposit(term);
        depositSteps.everyMonthPayment(everyMonthPay);
        depositSteps.checkBoxCapitalization(capitalization);
        depositSteps.checkBoxPartialDraw(withdrawalPartial);
        depositSteps.checksTheFields(valute);
    }
}