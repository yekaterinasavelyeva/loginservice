package lv.javaguru.java2.services.validators.rules.passwordinput;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

public class LetterAndNumberPasswordRule implements DataInputRule {
    @Override
    public boolean satisfiesCondition(String input) {
        boolean containsNumbers=input.matches("\\d+");
        boolean containsLetters=input.matches("[a-zA-Z]+");
        return containsLetters||containsNumbers;
    }

    @Override
    public boolean satisfiesCondition(Long userId, String input, UserDAO dao) {
        boolean containsNumbers=input.matches("\\d+");
        boolean containsLetters=input.matches("[a-zA-Z]+");
        return containsLetters||containsNumbers;
    }

    @Override
    public void produceResult(Long userId, String password, UserDAO dao) {
        throw new IllegalArgumentException("Password must contain at least one number and one letter");
    }

    @Override
    public void produceResult(String input) {
        throw new IllegalArgumentException("Password must contain at least one number and one letter");
    }
}
