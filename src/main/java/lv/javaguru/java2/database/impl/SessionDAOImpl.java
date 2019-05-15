package lv.javaguru.java2.database.impl;

import lv.javaguru.java2.database.SessionDAO;
import lv.javaguru.java2.domain.Session;
import lv.javaguru.java2.domain.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * Created by user Yekaterina Savelyeva
 * on 22.03.2019
 */

@Stateless
@Named
public class SessionDAOImpl implements SessionDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Session save(Session session) {
        em.persist(session);
        return getById(session.getSessionId()).get();
    }

    @Override
    public Optional<Session> getById(String session_id) {
        return em.createQuery("select s from Session s where s.sessionId = :sessionId")
                .setParameter("sessionId", session_id)
                .getResultList().stream()
                .findFirst();
    }

    @Override
    public Optional<Session> getByUser(User user) {
        return em.createQuery("select s from Session s where s.authUser = :authUser")
                .setParameter("authUser", user)
                .getResultList().stream()
                .findFirst();
    }

    @Override
    public void delete(String session_id) {
        em.createQuery("delete from Session s where s.sessionId = :sessionId")
                .setParameter("sessionId", session_id).executeUpdate();
    }

    @Override
    public void deleteByUser(User user){
        em.createQuery("delete from Session s where s.authUser = :authUser")
                .setParameter("authUser", user).executeUpdate();
    }
}
