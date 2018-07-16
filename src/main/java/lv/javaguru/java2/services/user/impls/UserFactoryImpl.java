package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.user.UserFactory;
import lv.javaguru.java2.services.validators.impls.DataInputValidatorImpl;
import lv.javaguru.java2.services.validators.rules.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.passwordinput.EmptyOrNullPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.LetterAndNumberPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.MinLengthPasswordRule;
import lv.javaguru.java2.services.validators.UserPropertiesValidator;
import lv.javaguru.java2.services.validators.impls.UserPropertiesValidatorImpl;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

public class UserFactoryImpl implements UserFactory {

    private UserPropertiesValidator propertiesValidator = new UserPropertiesValidatorImpl();
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
