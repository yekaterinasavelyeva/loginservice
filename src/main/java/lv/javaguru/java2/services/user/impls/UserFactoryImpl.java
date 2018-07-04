package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.user.UserFactory;
import lv.javaguru.java2.services.validators.impls.UserValidatorImpl;
import lv.javaguru.java2.services.validators.UserValidator;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

public class UserFactoryImpl implements UserFactory {

    private UserValidator userValidator = new UserValidatorImpl();
    private UserDAO userDAO = new UserDAOImpl();


    @Override
    public User create(String login, String password) {
        userValidator.validate(login, password);

        User user = createUser()
                .withLogin(login)
                .withPassword(password).build();

        return userDAO.save(user);
    }

}
