package lv.javaguru.java2.services.validators.rules;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.UserState;

/**
 * Created by user Yekaterina Savelyeva
 * on 13.11.2018
 */

public interface StateInputRule {

    boolean satisfiesCondition(UserState input);

    boolean satisfiesCondition(Long userId, UserState input, UserDAO dao);

    void produceResult(UserState input);

    void produceResult(Long userId, UserState input, UserDAO dao);
}
