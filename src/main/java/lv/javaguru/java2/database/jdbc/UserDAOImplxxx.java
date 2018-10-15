package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Yekaterina Savelyeva
 * on 14.10.2018
 */

@Transactional
public class UserDAOImplxxx implements UserDAO {

    private static final String PERSISTENCE_UNIT_NAME = "User";

    EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    @PersistenceContext
    private EntityManager em = factory.createEntityManager();

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
