package lv.javaguru.java2.services.validators.rules.inputimpls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

import javax.inject.Named;

/**
 * Created by Yekaterina Savelyeva
 * on 20.07.2018
 */
public class InputRule implements DataInputRule {
    @Override
    public boolean satisfiesCondition(String input) {
        return true;
    }

    @Override
    public boolean satisfiesCondition(Long userId, String input, UserDAO dao) {
        return true;
    }

    @Override
    public void produceResult(Long userId, String input, UserDAO dao, String message) {
        throw new IllegalArgumentException(message + " is ok.");
    }

    @Override
    public void produceResult(String input, String message) {
        throw new IllegalArgumentException("Database is not specified.");
    }
}
