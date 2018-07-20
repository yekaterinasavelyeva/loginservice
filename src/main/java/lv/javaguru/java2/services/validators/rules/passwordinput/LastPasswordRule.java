package lv.javaguru.java2.services.validators.rules.passwordinput;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.validators.rules.DataInputRule;

/**
 * Created by Yekaterina Savelyeva
 * on 20.07.2018
 */

public class LastPasswordRule  implements DataInputRule {
    @Override
    public boolean satisfiesCondition(Long userId, String password, UserDAO dao) {
        User user = dao.getById(userId).get();
        if(password.equals(user.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public void produceResult(Long userId, String password, UserDAO dao) {
        throw new IllegalArgumentException("Password matches previous one!");
    }

    @Override
    public boolean satisfiesCondition(String password) {
        return false;
    }

    @Override
    public void produceResult(String password) {
        throw new IllegalArgumentException("Password matches previous one!");
    }
}
