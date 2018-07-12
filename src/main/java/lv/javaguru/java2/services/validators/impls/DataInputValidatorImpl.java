package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.services.user.rules.DataInputRule;
import lv.javaguru.java2.services.validators.DataInputValidator;

import java.util.Arrays;

public class DataInputValidatorImpl implements DataInputValidator {

    private DataInputRule[] rules;

    public DataInputValidatorImpl(DataInputRule... rules){
        this.rules = rules;
    }

    @Override
    public void validate(String input) {
        Arrays.stream(rules).filter(r -> r.satisfiesCondition(input)).findAny().get().produceResult(input);
    }
}
