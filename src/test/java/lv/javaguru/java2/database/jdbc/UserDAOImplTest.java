package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;
import org.junit.Test;

import java.util.Optional;

import static lv.javaguru.java2.domain.UserBuilder.createUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserDAOImplTest extends DBUnitTestCase {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected String getDatabaseFile() {
        return "dbscripts/UserDAOImplTest.xml";
    }

    @Test
    public void testCreate() throws Exception {
        User user = createUser()
                .withLogin("L")
                .withPassword("P")
                .withFirstName("F")
                .withLastName("LA")
                .withState(UserState.VISITOR).build();

        userDAO.save(user);

        Optional<User> userFromDB = userDAO.getById(user.getUserId());
        assertTrue(userFromDB.isPresent());
        assertEquals(user.getUserId(), userFromDB.get().getUserId());
        assertEquals(user.getLogin(), userFromDB.get().getLogin());
        assertEquals(user.getPassword(), userFromDB.get().getPassword());
        assertEquals(user.getFirstName(), userFromDB.get().getFirstName());
        assertEquals(user.getLastName(), userFromDB.get().getLastName());
        assertEquals(user.getState(), userFromDB.get().getState());
    }

    @Test
    public void testDelete() throws Exception {
        Long userId = userDAO.getAll().stream().findAny().get().getUserId();
        userDAO.delete(userId);
        Optional <User> userFromDB = userDAO.getById(userId);
        assertFalse(userFromDB.isPresent());
    }

    @Test
    public void testUpdate() throws Exception {
        Long userId = userDAO.getAll().stream().findAny().get().getUserId();
        User user = userDAO.getById(userId).get();
        user.setState(UserState.ADMIN);
        user.setFirstName("Katy");
        user.setLastName("Savelyeva");
        user.setPassword("abrakadabra");
        userDAO.update(user);
        assertEquals(user.getState(), userDAO.getById(userId).get().getState());
        assertEquals(user.getFirstName(), userDAO.getById(userId).get().getFirstName());
        assertEquals(user.getLastName(), userDAO.getById(userId).get().getLastName());
        assertEquals(user.getPassword(), userDAO.getById(userId).get().getPassword());
    }

}
