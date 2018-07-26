package lv.javaguru.java2.services.validators.rules.passwordinput;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

public class MinLengthPasswordRule implements DataInputRule {

    @Override
    public boolean satisfiesCondition(String input) {
         return input.length() < 6;
    }

    @Override
    public boolean satisfiesCondition(Long userId, String input, UserDAO dao) {
        return input.length() < 6;
    }

    @Override
    public void produceResult(Long userId, String input, UserDAO dao) {
        throw new IllegalArgumentException("Password must be at least 6 symbols long!");
    }

    @Override
    public void produceResult(String input) {
        throw new IllegalArgumentException("Password must be at least 6 symbols long!");
    }
}