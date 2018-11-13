package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.inputimpls.EmptyOrNullInputRule;
import lv.javaguru.java2.services.validators.rules.inputimpls.LetterAndNumberInputRule;
import lv.javaguru.java2.services.validators.rules.inputimpls.MinLengthInputRule;
import lv.javaguru.java2.services.validators.rules.inputimpls.InputRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.inject.Inject;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public class DataInputValidatorImplTest {

    @InjectMocks
    private DataInputValidatorImpl validator;

    @Mock
    private UserDAO dao;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenPasswordIsNull() {
        validator = new DataInputValidatorImpl(dao,new EmptyOrNullInputRule(), new InputRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must not be empty!");
        validator.validateInput(null, "Password");
    }

    @Test
    public void shouldThrowExceptionWhenPasswordIsEmpty(){
        validator = new DataInputValidatorImpl(dao,new EmptyOrNullInputRule(), new InputRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must not be empty!");
        validator.validateInput("", "Password");
    }

    @Test
    public void shouldThrowExceptionWhenPasswordContainsOnlyLetters(){
        validator = new DataInputValidatorImpl(dao, new LetterAndNumberInputRule(), new InputRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must contain at least one number and one letter");
        validator.validateInput("password", "Password");
    }

    @Test
    public void shouldThrowExceptionWhenPasswordContainsOnlyNumbers(){
        validator = new DataInputValidatorImpl(dao, new LetterAndNumberInputRule(), new InputRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must contain at least one number and one letter");
        validator.validateInput("123456", "Password");
    }

    @Test
    public void shouldThrowExceptionWhenPasswordMinLengthIsNotReached(){
        validator = new DataInputValidatorImpl(dao, new MinLengthInputRule(), new InputRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must be at least 6 symbols long!");
        validator.validateInput("abc", "Password");
    }

    @Test
    public void shouldThrowExactException(){
        validator = new DataInputValidatorImpl(dao, new EmptyOrNullInputRule(),
                new LetterAndNumberInputRule(), new MinLengthInputRule(), new InputRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must be at least 6 symbols long!");
        validator.validateInput("pass1", "Password");
    }

    @Test
    public void shouldThrowConfirmationExceptionWhenPasswordValid1(){
        validator = new DataInputValidatorImpl(dao, new EmptyOrNullInputRule(),
                new LetterAndNumberInputRule(), new MinLengthInputRule(), new InputRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Database is not specified.");
        validator.validateInput("password1", "Password");
    }

    @Test
    public void shouldThrowConfirmationExceptionWhenPasswordValid2(){
        validator = new DataInputValidatorImpl(dao, new EmptyOrNullInputRule(),
                new LetterAndNumberInputRule(), new MinLengthInputRule(), new InputRule());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password is ok.");
        validator.validateData(1l, "password1", "Password");
    }

}