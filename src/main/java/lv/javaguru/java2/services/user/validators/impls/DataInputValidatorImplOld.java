package lv.javaguru.java2.services.user.validators.impls;

import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.user.validators.DataInputValidator;

import javax.inject.Named;

/**
 * Created by user
 * on 01.03.2019
 */

@Named("old_input_validator")
public class DataInputValidatorImplOld {

    public void validateUserFirstNameInput(String firstName) {
        firstName = firstName == null ? null : firstName.trim();
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First Name cannot be empty!");
        }
    }


    public void validateUserLastNameInput(String lastName) {
        lastName = lastName == null ? null : lastName.trim();
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last Name cannot be empty!");
        }
    }

    public void validateUserStateInput(UserState state) {
        if (state == null) {
            throw new IllegalArgumentException("User type cannot be empty!");
        }
    }

    public void validateUserLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login cannot be empty!");
        }
        if (!login.matches("\\w+")) {
            throw new IllegalArgumentException("Unacceptable symbols detected in login!");
        }
        if (login.length() < 5) {
            throw new IllegalArgumentException("Login is too short!");
        }
    }

    public void validateUserPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty!");
        }
        if(!password.matches("\\w+")){
            throw new IllegalArgumentException("Unacceptable symbols detected in password!");
        }
        if(password.matches("\\d+") || password.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("Password must contain letters and numbers!");
        }
        if(password.length() < 5){
            throw new IllegalArgumentException("Password is too short!");
        }
        if(!password.matches("^(?=.*[A-Z]).+$")){
            throw new IllegalArgumentException("At least one capital letter is expected!");
        }
    }
}
