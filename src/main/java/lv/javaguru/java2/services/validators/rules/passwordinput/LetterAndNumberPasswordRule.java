package lv.javaguru.java2.services.validators.rules.passwordinput;

import lv.javaguru.java2.services.validators.rules.DataInputRule;

public class LetterAndNumberPasswordRule implements DataInputRule {
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
