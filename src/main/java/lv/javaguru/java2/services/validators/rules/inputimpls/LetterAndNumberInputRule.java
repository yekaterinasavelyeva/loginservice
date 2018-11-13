package lv.javaguru.java2.services.validators.rules.inputimpls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

import javax.inject.Named;


public class LetterAndNumberInputRule implements DataInputRule {
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
    public void produceResult(Long userId, String password, UserDAO dao, String message) {
        throw new IllegalArgumentException(message + " must contain at least one number and one letter");
    }

    @Override
    public void produceResult(String input, String message) {
        throw new IllegalArgumentException(message + " must contain at least one number and one letter");
    }
}
