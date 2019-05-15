package lv.javaguru.java2.services.user.validators.impls;

import lv.javaguru.java2.services.user.validators.DataInputValidator;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Created by user Yekaterina Savelyeva
 * on 01.03.2019
 */

public class DataInputValidatorImplTest {

   //private DataInputValidator validator = new DataInputValidatorImplOld();

    @Rule
    public ExpectedException thrown = ExpectedException.none();
/*

    @Test
    void validateFirstName() {
        Executable nullName = () -> validator.validateUserFirstNameInput(null);
        Executable emptyName1 = () -> validator.validateUserFirstNameInput("");
        Executable emptyName2 = () -> validator.validateUserFirstNameInput("    ");
        Executable goodName1 = () -> validator.validateUserFirstNameInput("goodName");
        Executable goodName2 = () -> validator.validateUserFirstNameInput(" good Name  ");

        IllegalArgumentException ar1 = assertThrows(IllegalArgumentException.class, nullName);
        IllegalArgumentException ar2 = assertThrows(IllegalArgumentException.class, emptyName1);
        IllegalArgumentException ar3 = assertThrows(IllegalArgumentException.class, emptyName2);

        assertEquals(ar1.getMessage(), "First Name cannot be empty!");
        assertEquals(ar2.getMessage(), "First Name cannot be empty!");
        assertEquals(ar3.getMessage(), "First Name cannot be empty!");

        try {
            goodName1.execute();
            goodName2.execute();
        } catch (Throwable throwable) {
            fail(throwable.getMessage() + " was thrown");
        }
    }

    @Test
    void validateLastName(){
        Executable nullLastName = () -> validator.validateUserLastNameInput(null);
        Executable emptyLastName1 = () -> validator.validateUserLastNameInput("");
        Executable emptyLastName2 = () -> validator.validateUserLastNameInput("    ");
        Executable goodLastName1 = () -> validator.validateUserLastNameInput("goodLastName");
        Executable goodLastName2 = () -> validator.validateUserLastNameInput(" goodLastName  ");

        IllegalArgumentException ar1 = assertThrows(IllegalArgumentException.class, nullLastName);
        IllegalArgumentException ar2 = assertThrows(IllegalArgumentException.class, emptyLastName1);
        IllegalArgumentException ar3 = assertThrows(IllegalArgumentException.class, emptyLastName2);

        assertEquals(ar1.getMessage(), "Last Name cannot be empty!");
        assertEquals(ar2.getMessage(), "Last Name cannot be empty!");
        assertEquals(ar3.getMessage(), "Last Name cannot be empty!");
        try {
            goodLastName1.execute();
            goodLastName2.execute();
        } catch (Throwable throwable) {
            fail(throwable.getMessage() + " was thrown");
        }

    }

    @Test
    void validateState(){
        Executable nullState = () -> validator.validateUserStateInput(null);
        Executable goodState = () -> validator.validateUserStateInput(UserState.VISITOR);
        IllegalArgumentException ar1 = assertThrows(IllegalArgumentException.class, nullState);
        assertEquals(ar1.getMessage(), "User type cannot be empty!");

        try {
            goodState.execute();
        } catch (Throwable throwable) {
            fail(throwable.getMessage() + " was thrown");
        }
    }

    @Test
    void validateLogin(){
        Executable nullLogin = () -> validator.validateUserLogin(null);
        Executable emptyLogin1 = () -> validator.validateUserLogin("");
        Executable emptyLogin2 = () -> validator.validateUserLogin("    ");
        Executable shortLogin = () -> validator.validateUserLogin("yap");
        Executable unacceptableLogin = () -> validator.validateUserLogin(" badLogin  ");
        Executable goodLogin1 = () -> validator.validateUserLogin("goodlogin");
        Executable goodLogin2 = () -> validator.validateUserLogin("goodlogin11");

        IllegalArgumentException ar1 = assertThrows(IllegalArgumentException.class, nullLogin);
        IllegalArgumentException ar2 = assertThrows(IllegalArgumentException.class, emptyLogin1);
        IllegalArgumentException ar3 = assertThrows(IllegalArgumentException.class, emptyLogin2);
        IllegalArgumentException ar4 = assertThrows(IllegalArgumentException.class, shortLogin);
        IllegalArgumentException ar5 = assertThrows(IllegalArgumentException.class, unacceptableLogin);

        assertEquals(ar1.getMessage(), "Login cannot be empty!");
        assertEquals(ar2.getMessage(), "Login cannot be empty!");
        assertEquals(ar3.getMessage(), "Unacceptable symbols detected in login!");
        assertEquals(ar4.getMessage(), "Login is too short!");
        assertEquals(ar5.getMessage(), "Unacceptable symbols detected in login!");
        try {
            goodLogin1.execute();
            goodLogin2.execute();
        } catch (Throwable throwable) {
            fail(throwable.getMessage() + " was thrown");
        }
    }

    @Test
    void validatePassword(){
        Executable nullPassword = () -> validator.validateUserPassword(null);
        Executable emptyPassword1 = () -> validator.validateUserPassword("");
        Executable emptyPassword2 = () -> validator.validateUserPassword("    ");
        Executable badPassword1 = () -> validator.validateUserPassword("sup2");
        Executable badPassword2 = () -> validator.validateUserPassword("supers");
        Executable badPassword3 = () -> validator.validateUserPassword("sup er");
        Executable badPassword4 = () -> validator.validateUserPassword("super3");
        Executable goodPassword1 = () -> validator.validateUserPassword("goodPassword1");

        IllegalArgumentException ar1 = assertThrows(IllegalArgumentException.class, nullPassword);
        IllegalArgumentException ar2 = assertThrows(IllegalArgumentException.class, emptyPassword1);
        IllegalArgumentException ar3 = assertThrows(IllegalArgumentException.class, emptyPassword2);
        IllegalArgumentException ar4 = assertThrows(IllegalArgumentException.class, badPassword1);
        IllegalArgumentException ar5 = assertThrows(IllegalArgumentException.class, badPassword2);
        IllegalArgumentException ar6 = assertThrows(IllegalArgumentException.class, badPassword3);
        IllegalArgumentException ar7 = assertThrows(IllegalArgumentException.class, badPassword4);

        assertEquals(ar1.getMessage(), "Password cannot be empty!");
        assertEquals(ar2.getMessage(), "Password cannot be empty!");
        assertEquals(ar3.getMessage(), "Unacceptable symbols detected in password!");
        assertEquals(ar4.getMessage(), "Password is too short!");
        assertEquals(ar5.getMessage(), "Password must contain letters and numbers!");
        assertEquals(ar6.getMessage(), "Unacceptable symbols detected in password!");
        assertEquals(ar7.getMessage(), "At least one capital letter is expected!");
        try {
            goodPassword1.execute();
        } catch (Throwable throwable) {
            fail(throwable.getMessage() + " was thrown");
        }
    }
*/



}