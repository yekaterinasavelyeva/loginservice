package lv.javaguru.java2.services.validators.rules.inputimpls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

import javax.inject.Named;

/**
 * Created by user
 * on 13.11.2018
 */


public class LoginUniqueRule implements DataInputRule {

    @Override
    public boolean satisfiesCondition(String login) {
        return false;
    }

    @Override
    public boolean satisfiesCondition(Long userId, String login, UserDAO dao) {

        if(dao.getByLogin(login).isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public void produceResult(String login, String message) {
        throw new IllegalArgumentException("Login is not unique!");
    }

    @Override
    public void produceResult(Long userId, String login, UserDAO dao, String message) {
        throw new IllegalArgumentException("Login is not unique!");
    }
}
