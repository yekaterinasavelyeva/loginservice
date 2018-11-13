package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

@Named
public class DataInputValidatorImpl implements DataInputValidator {

    private DataInputRule[] rules;
    private UserDAO dao;

    public DataInputValidatorImpl(UserDAO dao, DataInputRule... rules){
        this.dao = dao;
        this.rules = rules;
    }

    @Override
    public void validateInput(String input, String message) {
        Arrays.stream(rules).filter(r -> r.satisfiesCondition(input)).findFirst().get().produceResult(input, message);
    }

    @Override
    public void validateData(Long userId, String input, String message){
        Arrays.stream(rules).filter(r -> r.satisfiesCondition(userId, input, dao))
                .findFirst().get().produceResult(userId, input, dao, message);
    }

}
