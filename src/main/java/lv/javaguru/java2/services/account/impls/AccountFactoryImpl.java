package lv.javaguru.java2.services.account.impls;

import lv.javaguru.java2.database.AccountDAO;
import lv.javaguru.java2.database.jdbc.AccountDAOImpl;
import lv.javaguru.java2.domain.Account;
import lv.javaguru.java2.domain.AccountState;
import lv.javaguru.java2.services.account.AccountFactory;

import static lv.javaguru.java2.domain.AccountBuilder.createAccount;

public class AccountFactoryImpl implements AccountFactory {

    private AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public Account create(String firstName, String lastName, AccountState state) {

        Account account = createAccount()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withStatus(state).build();

        return accountDAO.save(account);
    }
}
