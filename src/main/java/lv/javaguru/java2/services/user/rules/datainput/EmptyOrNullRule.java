package lv.javaguru.java2.services.user.rules.datainput;

import lv.javaguru.java2.services.user.rules.DataInputRule;

public class EmptyOrNullRule implements DataInputRule {

    @Override
    public boolean satisfiesCondition(String input) {
        return isBlank(input)||isNull(input);
    }

    @Override
    public void produceResult(String input) {
        throw new IllegalArgumentException("Password must not be empty!");
    }

    private boolean isNull(String str) {
        return str==null;
    }

    private boolean isBlank(String str) {
        return str=="";
    }
}
