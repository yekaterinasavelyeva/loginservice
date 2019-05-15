package lv.javaguru.java2.services.user.validators.impls;


import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.exceptions.UserPropertyException;
import lv.javaguru.java2.services.user.validators.SubjectValidator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by user Yekaterina Savelyeva
 * on 12.03.2019
 */

@RunWith(MockitoJUnitRunner.class)
public class SubjectValidatorImplTest {

    private static final Long EXAMPLE_LONG = 1234L;
    private static final String EXAMPLE_STRING = "example";

    @Mock
    private UserDAO dao;

    @Mock
    User user;

    @InjectMocks
    SubjectValidator validator = new SubjectValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void previousPasswordsTest() {
        thrown.expect(UserPropertyException.class);
        thrown.expectMessage("Password has to be different than previous ones!");
        when(dao.getAllPasswords(user.getUserId()))
                .thenReturn(Arrays.asList("Password1", "Password2", "Password3"));
        validator.validatePassword("Password3", user);
    }

    @Test
    public void previousPasswordRightTest(){
        thrown.reportMissingExceptionWithMessage("Password has to be different than previous ones!");
        when(dao.getAllPasswords(user.getUserId()))
                .thenReturn(Arrays.asList("Password1", "Password2", "Password3"));
        validator.validatePassword("Password4", user);
    }

    @Test
    public void loginUniqueTest(){
        thrown.expect(UserPropertyException.class);
        thrown.expectMessage("Login already exists. Try another one!");
        when(dao.getByLogin(EXAMPLE_STRING)).thenReturn(Optional.of(new User()));
        validator.validateLogin(EXAMPLE_STRING);
    }

    @Test
    public void loginUniqueRightTest(){
        thrown.reportMissingExceptionWithMessage("Login already exists. Try another one!");
        when(dao.getByLogin(EXAMPLE_STRING)).thenReturn(Optional.empty());
        validator.validateLogin(EXAMPLE_STRING);
    }


}