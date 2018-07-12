package lv.javaguru.java2.services.user.rules.datainput;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.user.rules.DataInputRule;

public class LetterAndNumberRule implements DataInputRule {
    @Override
    public boolean satisfiesCondition(String input) {
        boolean containsNumbers=input.matches("\\d+");
        boolean containsLetters=input.matches("[a-zA-Z]+");
        return containsLetters||containsNumbers;
    }

    @Override
    public void produceResult(String input) {
        throw new IllegalArgumentException("Password must contain at least one number and one letter");
    }
}
