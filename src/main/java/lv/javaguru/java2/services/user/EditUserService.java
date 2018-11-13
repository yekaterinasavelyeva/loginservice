package lv.javaguru.java2.services.user;

import lv.javaguru.java2.domain.UserState;

public interface EditUserService {

    void edit(Long userId, String firstName, String lastname, UserState state);

}
