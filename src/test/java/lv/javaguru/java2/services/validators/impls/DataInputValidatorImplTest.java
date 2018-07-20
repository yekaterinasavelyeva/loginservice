package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.services.validators.rules.passwordinput.EmptyOrNullPasswordRule;
import lv.javaguru.java2.services.validators.UserPropertiesValidator;
import lv.javaguru.java2.services.validators.rules.passwordinput.LetterAndNumberPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.MinLengthPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.PasswordRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public class DataInputValidatorImplTest {

    private DataInputValidatorImpl validator;
    private UserDAO dao = new UserDAOImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenPasswordIsNull() {
        validator = new DataInputValidatorImpl(dao,new EmptyOrNullPasswordRule(), new PasswordRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must not be empty!");
        validator.validateInput(null);
    }

    @Test
    public void shouldThrowExceptionWhenPasswordIsEmpty(){
        validator = new DataInputValidatorImpl(dao,new EmptyOrNullPasswordRule(), new PasswordRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must not be empty!");
        validator.validateInput("");
    }

    @Test
    public void shouldThrowExceptionWhenPasswordContainsOnlyLetters(){
        validator = new DataInputValidatorImpl(dao, new LetterAndNumberPasswordRule(), new PasswordRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must contain at least one number and one letter");
        validator.validateInput("password");
    }

    @Test
    public void shouldThrowExceptionWhenPasswordContainsOnlyNumbers(){
        validator = new DataInputValidatorImpl(dao, new LetterAndNumberPasswordRule(), new PasswordRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must contain at least one number and one letter");
        validator.validateInput("123456");
    }

    @Test
    public void shouldThrowExceptionWhenPasswordMinLengthIsNotReached(){
        validator = new DataInputValidatorImpl(dao, new MinLengthPasswordRule(), new PasswordRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must be at least 6 symbols long!");
        validator.validateInput("abc");
    }

    @Test
    public void shouldThrowExactException(){
        validator = new DataInputValidatorImpl(dao, new EmptyOrNullPasswordRule(),
                new LetterAndNumberPasswordRule(), new MinLengthPasswordRule(), new PasswordRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must be at least 6 symbols long!");
        validator.validateInput("pass1");
    }

    @Test
    public void shouldThrowConfirmationExceptionWhenPasswordValid(){
        validator = new DataInputValidatorImpl(dao, new EmptyOrNullPasswordRule(),
                new LetterAndNumberPasswordRule(), new MinLengthPasswordRule(), new PasswordRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Database is not specified.");
        validator.validateInput("password1");
    }

}