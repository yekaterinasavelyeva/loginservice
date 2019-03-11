package lv.javaguru.java2.services.user.validators.impls;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import lv.javaguru.java2.domain.User;
import org.junit.Test;

import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static lv.javaguru.java2.services.user.validators.impls.ValidationUtils.printErrorMessages;
import static lv.javaguru.java2.services.user.validators.impls.ValidationUtils.validate;

/**
 * Created by user
 * on 04.03.2019
 */

public class UserDataValidationTest {

    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();
    ValidationUtils utils = new ValidationUtils();
    User user = new User();

    @Test
    public void validateUser() {
        Set<ConstraintViolation<Object>> violations =  validate(user, validator);
        assertTrue(printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Last Name cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Password cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! First Name cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Login cannot be empty!\n"));

    }

    @Test
    public void validateUserWithUserName(){
        user.setFirstName("");
        Set<ConstraintViolation<Object>> violations =  validate(user, validator);
        assertTrue(printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Last Name cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Password cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Unacceptable symbols detected in First Name!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Login cannot be empty!\n"));

    }

    @Test
    public void validateUserWithUserNameAndLastName(){
        user.setFirstName("La");
        user.setLastName("Savelyeva");
        Set<ConstraintViolation<Object>> violations =  validate(user, validator);
        assertTrue(printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Password cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Login cannot be empty!\n"));

    }

    @Test
    public void validateUserWithLoginAndPassword1(){
        user.setFirstName("La");
        user.setLastName("Savelyeva");
        user.setLogin("abra");
        user.setPassword("gh_uutr");
        Set<ConstraintViolation<Object>> violations =  validate(user, validator);
        assertTrue(printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Password must contain letters, capital letters and numbers!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Login is too short!\n"));

    }

    @Test
    public void validateUserWithLoginAndPassword2(){
        user.setFirstName("La");
        user.setLastName("Savelyeva");
        user.setLogin("abra");
        user.setPassword("gh&uutrP4");
        Set<ConstraintViolation<Object>> violations =  validate(user, validator);
        assertTrue(printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Login is too short!\n"));
        assertTrue(printErrorMessages(violations).contains("Warning! Unacceptable symbols detected in password!\n"));

    }


}
