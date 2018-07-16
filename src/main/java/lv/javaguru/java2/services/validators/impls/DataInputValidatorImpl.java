package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.services.validators.rules.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

import java.util.Arrays;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public class DataInputValidatorImpl implements DataInputValidator {

    private DataInputRule[] rules;

    public DataInputValidatorImpl(DataInputRule... rules){
        this.rules = rules;
    }
    @Override
    public void validatePassword(String password) {
        Arrays.stream(rules).filter(r -> r.satisfiesCondition(password)).findAny().get().produceResult(password);
    }
}
