package lv.javaguru.java2.integration;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserBuilder;
import lv.javaguru.java2.domain.UserState;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import static lv.javaguru.java2.domain.UserBuilder.createUser;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOImplTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackages(true, User.class.getPackage(), UserBuilder.class.getPackage(), UserDAO.class.getPackage(),
                UserDAOImpl.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    UserDAO userDAO;

    private static User user_here = createUser()
            .withLogin("Login1")
            .withPassword("Password1")
            .withFirstName("F")
            .withLastName("LA")
            .withState(UserState.VISITOR).build();

        @Test
        @Category(lv.javaguru.java2.integration.IntegrationTest.class)
        public void testCreate () {

            User dbuser = userDAO.save(user_here);
            System.out.println("Found " + dbuser);

            Optional<User> userFromDB = userDAO.getById(dbuser.getUserId());
            assertTrue(userFromDB.isPresent());
            assertEquals(user_here.getUserId(), userFromDB.get().getUserId());
            assertEquals(user_here.getLogin(), userFromDB.get().getLogin());
            assertEquals(user_here.getPassword(), userFromDB.get().getPassword());
            assertEquals(user_here.getFirstName(), userFromDB.get().getFirstName());
            assertEquals(user_here.getLastName(), userFromDB.get().getLastName());
            assertEquals(user_here.getState(), userFromDB.get().getState());
        }

        @Test
        @Category(lv.javaguru.java2.integration.IntegrationTest.class)
        public void testDelete() {

            User dbUser = userDAO.getAll().stream().findAny().get();
            System.out.println("User from database: \n" + dbUser.toString());
            Long userId = dbUser.getUserId();
            userDAO.delete(userId);
            Optional <User> userFromDB = userDAO.getById(userId);
            assertFalse(userFromDB.isPresent());
        }

        @Test
        @Category(lv.javaguru.java2.integration.IntegrationTest.class)
        public void testUpdate() {
            userDAO.save(user_here);
            Long userId = userDAO.getAll().stream().findAny().get().getUserId();
            User user = userDAO.getById(userId).get();
            user.setState(UserState.ADMIN);
            user.setFirstName("Katy");
            user.setLastName("Savelyeva");
            userDAO.update(user);
            User userDB = userDAO.getById(userId).get();
            System.out.println("User from database: \n" + userDB);
            assertEquals(user.getUserId(), userDB.getUserId());
            assertEquals(user.getState(), userDB.getState());
            assertEquals(user.getFirstName(), userDB.getFirstName());
            assertEquals(user.getLastName(), userDB.getLastName());
            assertEquals(user.getPassword(), userDB.getPassword());
        }

        @Test
        @Category(lv.javaguru.java2.integration.IntegrationTest.class)
        public void testUpdatePassword() {

            Long userId = userDAO.getAll().stream().findAny().get().getUserId();
            User user = userDAO.getById(userId).get();
            userDAO.updatePassword(userId, "newPassword123");
            User userDB = userDAO.getById(userId).get();
            System.out.println("User from database: \n" + userDB);
            List<String> passwords = userDAO.getAllPasswords(userId);

            assertEquals("newPassword123", passwords.get(0));
            assertEquals(user.getPassword(), passwords.get(1));
            assertEquals(user.getLastPassword(), passwords.get(2));
        }

}
