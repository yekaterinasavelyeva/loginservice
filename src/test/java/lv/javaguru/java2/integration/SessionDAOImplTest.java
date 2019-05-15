package lv.javaguru.java2.integration;

import lv.javaguru.java2.database.SessionDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.impl.SessionDAOImpl;
import lv.javaguru.java2.database.impl.UserDAOImpl;
import lv.javaguru.java2.domain.Session;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import javax.inject.Inject;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static lv.javaguru.java2.domain.UserBuilder.createUser;
import static org.junit.Assert.assertFalse;

/**
 * Created by user Yekaterina Savelyeva
 * on 22.03.2019
 */

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessionDAOImplTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackages(true, User.class.getPackage(),
                        UserBuilder.class.getPackage(), UserDAO.class.getPackage(),
                        UserDAOImpl.class.getPackage(), Session.class.getPackage(),
                        SessionDAO.class.getPackage(), SessionDAOImpl.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    SessionDAO sessionDAO;

    @Inject
    UserDAO userDAO;

    private User user;
    private Session session;
    private User dbUser;
    private Session dbSession;

    @Test
    @Category(lv.javaguru.java2.integration.IntegrationTest.class)
    public void testCreate () {

        user = createUser()
                .withLogin("Login2")
                .withPassword("Password2")
                .withFirstName("Katya")
                .withLastName("Savelyeva")
                .withState(UserState.VISITOR).build();
        session = new Session(user, "jalksfjlskdjflJFLdjf");
        dbUser = userDAO.save(user);
        dbSession = sessionDAO.save(session);
        Optional<Session> sessionFromDB = sessionDAO.getByUser(dbUser);
        assertTrue(sessionFromDB.isPresent());
        assertEquals(sessionFromDB.get().getSessionId(), ("jalksfjlskdjflJFLdjf"));
        Optional<Session> anotherSessionFromDB = sessionDAO.getById("jalksfjlskdjflJFLdjf");
        assertTrue(anotherSessionFromDB.isPresent());
        assertEquals(anotherSessionFromDB.get().getUser(), sessionFromDB.get().getUser());
    }

    @Test
    @Category(lv.javaguru.java2.integration.IntegrationTest.class)
    public void testDelete() {

        Session dbSession = sessionDAO.getById("jalksfjlskdjflJFLdjf").get();
        System.out.println("Session from database: " + dbSession.toString());
        User currentUser = dbSession.getUser();
        sessionDAO.deleteByUser(currentUser);
        Optional<Session> sessionFromDB = sessionDAO.getById("jalksfjlskdjflJFLdjf");
        assertFalse(sessionFromDB.isPresent());

    }

    @Test
    @Category(lv.javaguru.java2.integration.IntegrationTest.class)
    public void testDelete2(){
        User newUser = createUser()
                .withLogin("Login30")
                .withPassword("Password3")
                .withFirstName("Liza")
                .withLastName("Savelyeva")
                .withState(UserState.VISITOR).build();
        Session newSession = new Session(newUser, "jalksfjlskjksjfdksjdfksflJFLdjf");
        dbUser = userDAO.save(newUser);
        sessionDAO.save(newSession);
        sessionDAO.delete("jalksfjlskjksjfdksjdfksflJFLdjf");
        Optional<Session> sessionFromDB = sessionDAO.getByUser(dbUser);
        assertFalse(sessionFromDB.isPresent());
    }


}
