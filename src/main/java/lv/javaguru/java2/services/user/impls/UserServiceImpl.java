package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.user.UserService;
import lv.javaguru.java2.services.validators.UserValidator;
import lv.javaguru.java2.services.validators.impls.UserValidatorImpl;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();
    private UserValidator userValidator = new UserValidatorImpl();

    @Override
    public void edit(Long userId,
                     String login,
                     String password) {
        Optional<User> userOpt = userDAO.getById(userId);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("User not found by id = " + userId);
        }

        userValidator.validate(login, password);

        User user = userOpt.get();
        user.setLogin(login);
        user.setPassword(password);
        userDAO.update(user);
    }

}
