package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.services.validators.rules.passwordinput.EmptyOrNullPasswordRule;
import lv.javaguru.java2.services.validators.UserPropertiesValidator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public class DataInputValidatorImplTest {

    private DataInputValidatorImpl validator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenPasswordIsNull() {
        validator = new DataInputValidatorImpl(new EmptyOrNullPasswordRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must not be empty!");
        validator.validatePassword(null);
    }


}