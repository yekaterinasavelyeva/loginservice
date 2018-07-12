package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.services.user.rules.datainput.EmptyOrNullRule;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.impls.DataInputValidatorImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EditUserPasswordServiceImplTest {

    private DataInputValidator validator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenPasswordIsNull() {
        validator = new DataInputValidatorImpl(new EmptyOrNullRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must not be empty!");
        validator.validate(null);
    }

}