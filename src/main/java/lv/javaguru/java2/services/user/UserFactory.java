package lv.javaguru.java2.services.user;

import lv.javaguru.java2.domain.User;

public interface UserFactory {

    User create(String login, String password);

}
