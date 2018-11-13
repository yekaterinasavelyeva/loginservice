package lv.javaguru.java2.services.validators.rules.inputimpls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

import javax.inject.Named;

public class EmptyOrNullInputRule implements DataInputRule {

    @Override
    public boolean satisfiesCondition(String input) {
        return isBlank(input)||isNull(input);
    }

    @Override
    public void produceResult(String input, String message) {
        throw new IllegalArgumentException(message + " must not be empty!");
    }

    @Override
    public boolean satisfiesCondition(Long userId, String input, UserDAO dao) {
        return isBlank(input)||isNull(input);
    }

    @Override
    public void produceResult(Long userId, String input, UserDAO dao, String message) {
        throw new IllegalArgumentException(message + " must not be empty!");
    }

    private boolean isBlank(String str) {
        return str=="";
    }

    private boolean isNull(String str) {
        return str==null;
    }
}
