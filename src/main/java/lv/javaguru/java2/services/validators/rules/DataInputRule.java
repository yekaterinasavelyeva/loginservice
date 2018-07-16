package lv.javaguru.java2.services.validators.rules;

import lv.javaguru.java2.domain.User;

public interface DataInputRule {

    boolean satisfiesCondition(String password);

    void produceResult(String password);
}
