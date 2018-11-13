package lv.javaguru.java2.integration;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserBuilder;
import lv.javaguru.java2.domain.UserState;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import java.util.*;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

/**
 * Created by user
 * on 08.11.2018
 */
@RunWith(Arquillian.class)
public class UserPersistenceTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackages(true, User.class.getPackage(), UserBuilder.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction utx;

    private static final User[] users_here = {createUser()
            .withLogin("L")
            .withPassword("P")
            .withFirstName("F")
            .withLastName("LA")
            .withState(UserState.VISITOR).build()};

    @Before
    public void preparePersistenceTest() throws Exception {
        clearData();
        insertData();
        startTransaction();
    }

    @After
    public void commitTransaction() throws Exception {
        utx.commit();
    }

    private void clearData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Dumping old records...");
        em.createQuery("delete from User").executeUpdate();
        utx.commit();
    }

    private void insertData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Inserting records...");
        User user = createUser()
                .withLogin("L")
                .withPassword("P")
                .withFirstName("F")
                .withLastName("LA")
                .withState(UserState.VISITOR).build();
        em.persist(user);
        utx.commit();
        // clear the persistence context (first-level cache)
        em.clear();
    }

    private void startTransaction() throws Exception {
        utx.begin();
        em.joinTransaction();
    }

    @Test
    @Category(lv.javaguru.java2.integration.IntegrationTest.class)
    public void shouldFindAllUsersUsingJpqlQuery() {
        // given
        String fetchingAllUsers = "select u from User u order by u.userId";

        // when
        System.out.println("Selecting (using JPQL)...");
        List<User> users = em.createQuery(fetchingAllUsers, User.class).getResultList();

        // then
        System.out.println("Found " + users.size() + " users (using JPQL):");
        Assert.assertEquals(users_here.length, users.size());
        User hereUser = Arrays.asList(users_here).get(0);
        User dbUser = users.get(0);
        Assert.assertTrue(hereUser.getFirstName().equals(dbUser.getFirstName()));
        Assert.assertTrue(hereUser.getLastName().equals(dbUser.getLastName()));
        Assert.assertTrue(hereUser.getLogin().equals(dbUser.getLogin()));
        Assert.assertTrue(hereUser.getPassword().equals(dbUser.getPassword()));
        Assert.assertTrue(hereUser.getState().equals(dbUser.getState()));


    }
}
