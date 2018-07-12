package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.user.EditUserPasswordService;
import lv.javaguru.java2.services.user.rules.datainput.EmptyOrNullRule;
import lv.javaguru.java2.services.user.rules.datainput.LetterAndNumberRule;
import lv.javaguru.java2.services.user.rules.datainput.MinLengthRule;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.impls.DataInputValidatorImpl;

import java.util.Optional;

public class EditUserPasswordServiceImpl implements EditUserPasswordService {

    private UserDAO userDAO = new UserDAOImpl();
    private DataInputValidator dataInputValidator =
            new DataInputValidatorImpl(new EmptyOrNullRule(),
                    new LetterAndNumberRule(),
                    new MinLengthRule());

    @Override
    public void edit(Long userId, String password) {
        Optional<User> userOpt = userDAO.getById(userId);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("User not found by id = " + userId);
        }

        User user = userOpt.get();
        dataInputValidator.validate(password);

        user.setPassword(password);

        userDAO.update(user);
    }

}
