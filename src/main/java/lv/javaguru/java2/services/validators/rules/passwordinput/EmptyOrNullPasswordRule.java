package lv.javaguru.java2.services.validators.rules.passwordinput;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

public class EmptyOrNullPasswordRule implements DataInputRule {

    @Override
    public boolean satisfiesCondition(String input) {
        return isBlank(input)||isNull(input);
    }

    @Override
    public void produceResult(String input) {
        throw new IllegalArgumentException("Password must not be empty!");
    }

    @Override
    public boolean satisfiesCondition(Long userId, String input, UserDAO dao) {
        return isBlank(input)||isNull(input);
    }

    @Override
    public void produceResult(Long userId, String input, UserDAO dao) {
        throw new IllegalArgumentException("Password must not be empty!");
    }

    private boolean isBlank(String str) {
        return str=="";
    }

    private boolean isNull(String str) {
        return str==null;
    }
}
