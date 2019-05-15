package lv.javaguru.java2.services.user.validators.impls;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserBuilder;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.user.validators.impls.DataInputValidatorImpl;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.Set;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by user Yekaterina Savelyeva
 * on 04.03.2019
 */

public class UserDataValidationTest {

    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();
    DataInputValidatorImpl utils = new DataInputValidatorImpl();
    User user = new User();

    @Test
    public void validateUser() {
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertTrue(utils.printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Last Name cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Password cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! First Name cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Login cannot be empty!\n"));

    }

    @Test
    public void validateUserWithUserName(){
        user.setFirstName("");
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertTrue(utils.printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Last Name cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Password cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Unacceptable symbols detected in First Name!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Login cannot be empty!\n"));

    }

    @Test
    public void validateUserWithUserNameAndLastName(){
        user.setFirstName("La");
        user.setLastName("Savelyeva");
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertTrue(utils.printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Password cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Login cannot be empty!\n"));

    }

    @Test
    public void validateUserWithLoginAndPassword1(){
        user.setFirstName("La");
        user.setLastName("Savelyeva");
        user.setLogin("abra");
        user.setPassword("gh_uutr");
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertTrue(utils.printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Password must contain letters, capital letters and numbers!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Login is too short!\n"));

    }

    @Test
    public void validateUserWithLoginAndPassword2(){
        user.setFirstName("La");
        user.setLastName("Savelyeva");
        user.setLogin("abra");
        user.setPassword("gh&uutrP4");
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertTrue(utils.printErrorMessages(violations).contains("Warning! User type cannot be empty!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Login is too short!\n"));
        assertTrue(utils.printErrorMessages(violations).contains("Warning! Unacceptable symbols detected in password!\n"));

    }

    @Test
    public void validateFirstName(){
        user.setFirstName("ghth ");
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"firstName"), ("Warning! Unacceptable symbols detected in First Name!\n"));
    }

    @Test
    public void validateLastName(){
        user.setLastName("ght&");
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"lastName"), ("Warning! Unacceptable symbols detected in Last Name!\n"));
        user.setLastName(null);
        violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"lastName"), ("Warning! Last Name cannot be empty!\n"));
    }

    @Test
    public void validateStatus(){
        user.setLastName(null);
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"state"), ("Warning! User type cannot be empty!\n"));
    }

    @Test
    public void validateLogin(){
        user.setLogin("baba");
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"login"), ("Warning! Login is too short!\n"));
        user.setLogin("baba&hy");
        violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"login"), ("Warning! Unacceptable symbols detected in login!\n"));
        user.setLogin(null);
        violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"login"), ("Warning! Login cannot be empty!\n"));
    }

    @Test
    public void validatePassword(){
        user.setPassword("Ba1a");
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"password"), ("Warning! Password is too short!\n"));
        user.setPassword("4aBa&hy");
        violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"password"), ("Warning! Unacceptable symbols detected in password!\n"));
        user.setPassword(null);
        violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"password"), ("Warning! Password cannot be empty!\n"));
        user.setPassword("abrakadabra");
        violations =  utils.validate(user, validator);
        assertEquals(utils.printErrorForSpecificField(violations,"password"), ("Warning! Password must contain letters, capital letters and numbers!\n"));
    }

    @Test
    public void rightInputTest(){
        user = UserBuilder.createUser()
                .withFirstName("Bu")
                .withLastName("Bu")
                .withLogin("loginl")
                .withPassword("Password1")
                .withState(UserState.VISITOR)
                .build();
        Set<ConstraintViolation<Object>> violations =  utils.validate(user, validator);
        assertTrue(utils.printErrorMessages(violations).isEmpty());

    }

}
