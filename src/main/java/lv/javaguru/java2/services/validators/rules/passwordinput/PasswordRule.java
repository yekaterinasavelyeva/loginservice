package lv.javaguru.java2.services.validators.rules.passwordinput;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

/**
 * Created by Yekaterina Savelyeva
 * on 20.07.2018
 */

public class PasswordRule implements DataInputRule {
    @Override
    public boolean satisfiesCondition(String input) {
        return true;
    }

    @Override
    public boolean satisfiesCondition(Long userId, String input, UserDAO dao) {
        return true;
    }

    @Override
    public void produceResult(Long userId, String input, UserDAO dao) {
        throw new IllegalArgumentException("Password is ok.");
    }

    @Override
    public void produceResult(String input) {
        throw new IllegalArgumentException("Database is not specified.");
    }
}
