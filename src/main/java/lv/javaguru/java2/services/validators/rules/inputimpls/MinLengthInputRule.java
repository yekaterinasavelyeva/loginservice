package lv.javaguru.java2.services.validators.rules.inputimpls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

import javax.inject.Named;

public class MinLengthInputRule implements DataInputRule {

    @Override
    public boolean satisfiesCondition(String input) {
         return input.length() < 6;
    }

    @Override
    public boolean satisfiesCondition(Long userId, String input, UserDAO dao) {
        return input.length() < 6;
    }

    @Override
    public void produceResult(Long userId, String input, UserDAO dao, String message) {
        throw new IllegalArgumentException(message + " must be at least 6 symbols long!");
    }

    @Override
    public void produceResult(String input, String message) {
        throw new IllegalArgumentException(message + " must be at least 6 symbols long!");
    }
}
