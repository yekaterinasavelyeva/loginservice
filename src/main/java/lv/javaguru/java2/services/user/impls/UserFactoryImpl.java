package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.user.UserFactory;
import lv.javaguru.java2.services.validators.UserCreateValidator;
import lv.javaguru.java2.services.validators.impls.UserCreateValidatorImpl;

import javax.inject.Named;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */


public class UserFactoryImpl implements UserFactory {

    private UserCreateValidator propertiesValidator = new UserCreateValidatorImpl();
    private UserDAO userDAO = new UserDAOImpl();


    @Override
    public User create(String login, String password, String firstName, String lastName, UserState state) {
        propertiesValidator.validate(login, password, firstName, lastName, state);

        User user = createUser()
                .withLogin(login)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withState(state).build();

        return userDAO.save(user);
    }

}
