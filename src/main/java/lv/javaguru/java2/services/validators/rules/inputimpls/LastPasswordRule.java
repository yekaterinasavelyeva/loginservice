package lv.javaguru.java2.services.validators.rules.inputimpls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

import javax.inject.Named;

/**
 * Created by Yekaterina Savelyeva
 * on 20.07.2018
 */

public class LastPasswordRule  implements DataInputRule {
    @Override
    public boolean satisfiesCondition(Long userId, String password, UserDAO dao) {
        User user = dao.getById(userId).get();
        if(password.equals(user.getPassword())||
                password.equals(user.getLastPassword())||
                password.equals(user.getVeryLastPassword())){
            return true;
        }
        return false;
    }

    @Override
    public void produceResult(Long userId, String password, UserDAO dao, String message) {
        throw new IllegalArgumentException("Password matches one of three previous!");
    }

    @Override
    public boolean satisfiesCondition(String password) {
        return false;
    }

    @Override
    public void produceResult(String password, String message) {
        throw new IllegalArgumentException("Password matches one of three previous!");
    }
}
