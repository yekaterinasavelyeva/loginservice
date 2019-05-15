package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Session;
import lv.javaguru.java2.domain.User;

import java.util.Optional;

/**
 * Created by user
 * on 22.03.2019
 */

public interface SessionDAO {

    Session save(Session session);

    Optional<Session> getById(String session_id);

    Optional<Session> getByUser(User user);

    void delete(String session_id);

    void deleteByUser(User user);

}
