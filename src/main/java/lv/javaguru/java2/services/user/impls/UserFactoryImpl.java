package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.user.UserFactory;
import lv.javaguru.java2.services.user.rules.datainput.EmptyOrNullRule;
import lv.javaguru.java2.services.user.rules.datainput.LetterAndNumberRule;
import lv.javaguru.java2.services.user.rules.datainput.MinLengthRule;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.impls.DataInputValidatorImpl;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

public class UserFactoryImpl implements UserFactory {

    private DataInputValidator dataInputValidator = new DataInputValidatorImpl(new EmptyOrNullRule(),
                    new LetterAndNumberRule(),
                    new MinLengthRule());
    private UserDAO userDAO = new UserDAOImpl();


    @Override
    public User create(String login, String password, String firstName, String lastName, UserState state) {
        dataInputValidator.validate(login);
        dataInputValidator.validate(password);

        User user = createUser()
                .withLogin(login)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withState(state).build();

        return userDAO.save(user);
    }

}
