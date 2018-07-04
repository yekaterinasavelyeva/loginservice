package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Account;
import lv.javaguru.java2.domain.User;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {
    Account save(Account account);

    Optional<Account> getById(Long id);

    void delete(Long id);

    void update(Account account);

    List<Account> getAll();
}
