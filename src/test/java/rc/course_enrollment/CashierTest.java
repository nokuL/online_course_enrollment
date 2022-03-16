package rc.course_enrollment;

import org.junit.Test;
import rc.course_enrollment.model.practice.Cashier;
import rc.course_enrollment.model.practice.InvalidAmount;

public class CashierTest {

    @Test(expected = IllegalArgumentException.class)
    public void validateCashier(){
        Cashier.validateTransaction("USD", 10);
    }

    @Test(expected = InvalidAmount.class)
    public void validateAmount(){
        Cashier.validateTransaction("EUR", -10);
    }
}
