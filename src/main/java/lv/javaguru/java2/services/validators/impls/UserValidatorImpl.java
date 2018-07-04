package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.services.validators.UserValidator;

public class UserValidatorImpl implements UserValidator {

    @Override
    public void validate(String login, String password) {
        validateLogin(login);
        validatePassword(password);
    }

    private void validateLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login must be not empty!");
        }
    }

    private void validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password must be not empty!");
        }
    }

}
