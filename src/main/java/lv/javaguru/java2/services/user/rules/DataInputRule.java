package lv.javaguru.java2.services.user.rules;

import lv.javaguru.java2.domain.User;

public interface DataInputRule {

    boolean satisfiesCondition(String password);

    void produceResult(String password);
}
