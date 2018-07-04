package lv.javaguru.java2.services.validators;

import lv.javaguru.java2.domain.AccountState;

public interface AccountPropertyValidator {

    void validate(String firstName, String lastName, AccountState state);
}
