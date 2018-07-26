package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.user.EditUserService;
import lv.javaguru.java2.services.validators.UserEditValidator;
import lv.javaguru.java2.services.validators.impls.UserEditValidatorImpl;
import lv.javaguru.java2.services.validators.rules.passwordinput.EmptyOrNullPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.LetterAndNumberPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.MinLengthPasswordRule;
import lv.javaguru.java2.services.validators.UserPropertiesValidator;
import lv.javaguru.java2.services.validators.impls.UserPropertiesValidatorImpl;

import java.util.Optional;

public class EditUserServiceImpl implements EditUserService {

    private UserDAO userDAO = new UserDAOImpl();
    private UserEditValidator userEditValidator =
            new UserEditValidatorImpl();

    @Override
    public void edit(Long userId, String password, String firstName, String lastname, UserState state) {
        Optional<User> userOpt = userDAO.getById(userId);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("User not found by id = " + userId);
        }

        User user = userOpt.get();
        userEditValidator.validate(userId, password, firstName, lastname, state);

        user.setPassword(password);

        userDAO.update(user);
    }

}