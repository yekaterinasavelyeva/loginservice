package lv.javaguru.java2.services.account;

import lv.javaguru.java2.domain.Account;
import lv.javaguru.java2.domain.AccountState;

public interface AccountFactory {

    Account create(String firstName, String lastName, AccountState state);

}
