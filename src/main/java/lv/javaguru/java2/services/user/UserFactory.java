package lv.javaguru.java2.services.user;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;

public interface UserFactory {

    User create(String login, String password, String firstName, String lastName, UserState state);

}
