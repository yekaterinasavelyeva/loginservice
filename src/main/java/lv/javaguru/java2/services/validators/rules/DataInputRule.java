package lv.javaguru.java2.services.validators.rules;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;

public interface DataInputRule {

    boolean satisfiesCondition(String input);

    boolean satisfiesCondition(Long userId, String input, UserDAO dao);

    void produceResult(String input, String message);

    void produceResult(Long userId, String input, UserDAO dao, String message);
}
