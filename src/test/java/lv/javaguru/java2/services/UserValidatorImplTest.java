package lv.javaguru.java2.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserValidatorImplTest {

    private UserValidator validator = new UserValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenLoginIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Login must be not empty!");
        validator.validate(null, "password");
    }

    @Test
    public void shouldThrowExceptionWhenLoginIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Login must be not empty!");
        validator.validate("", "password");
    }


    // write more tests

}