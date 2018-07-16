package lv.javaguru.java2.services.validators.rules.passwordinput;

import lv.javaguru.java2.services.validators.rules.DataInputRule;

public class MinLengthPasswordRule implements DataInputRule {

    @Override
    public boolean satisfiesCondition(String input) {
         return input.length() < 6;
    }

    @Override
    public void produceResult(String input) {
        throw new IllegalArgumentException("Password must be at least 6 symbols long!");
    }
}
