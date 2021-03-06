package lv.javaguru.java2.database.impl;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Yekaterina Savelyeva
 * on 14.10.2018
 */

@Stateless
@Named
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User save(User user) {
        em.persist(user);
        return getByLogin(user.getLogin()).get();
    }

    @Override
    public Optional<User> getById(Long id) {
        return em.createQuery("select u from User u where u.userId = :userId")
                .setParameter("userId", id)
                .getResultList().stream()
                .findFirst();
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return em.createQuery("select u from User u where u.login = :login")
                .setParameter("login", login)
                .getResultList().stream()
                .findFirst();
    }

    @Override
    public void delete(Long id) {
        em.createQuery("delete from User u where u.userId = :userId")
                .setParameter("userId", id).executeUpdate();
    }

    @Override
    public void update(User user) {
        em.createQuery("update User u set u.firstName = :firstName, u.lastName = :lastName, u.state = :state "
                + "where u.userId = :userId")
                .setParameter("userId", user.getUserId())
                .setParameter("firstName", user.getFirstName())
                .setParameter("lastName", user.getLastName())
                .setParameter("state", user.getState()).executeUpdate();
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("select u from User u")
                .getResultList();
    }

    @Override
    public void updatePassword(Long userId, String newPassword){

        em.createQuery("update User u set u.veryLastPassword = u.lastPassword, u.lastPassword = u.password," +
                " u.password = :password " + "where u.userId = :userId")
                .setParameter("userId", userId)
                .setParameter("password", newPassword).executeUpdate();
    }

    @Override
    public List<String> getAllPasswords(Long userId){
        User passwordsUser =  getById(userId).get();
        List<String> passwords = new ArrayList<>();
        passwords.add(passwordsUser.getPassword());
        passwords.add(passwordsUser.getLastPassword());
        passwords.add(passwordsUser.getVeryLastPassword());
        return passwords;
    }
}
