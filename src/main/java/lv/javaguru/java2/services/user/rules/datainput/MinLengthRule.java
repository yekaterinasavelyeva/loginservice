package lv.javaguru.java2.services.user.rules.datainput;

import lv.javaguru.java2.services.user.rules.DataInputRule;

public class MinLengthRule implements DataInputRule {

    @Override
    public boolean satisfiesCondition(String input) {
         return input.length() < 6;
    }

    @Override
    public void produceResult(String input) {
        throw new IllegalArgumentException("Password must be at least 6 symbols long!");
    }
}
