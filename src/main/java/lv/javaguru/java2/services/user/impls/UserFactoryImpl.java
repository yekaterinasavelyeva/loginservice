package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.exceptions.UserPropertyException;
import lv.javaguru.java2.services.user.UserFactory;
import lv.javaguru.java2.services.user.validators.DataInputValidator;
import lv.javaguru.java2.services.user.validators.SubjectValidator;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

@Stateless
public class UserFactoryImpl implements UserFactory {

    @Inject
    private DataInputValidator propertiesValidator;

    @Inject
    private SubjectValidator subjectValidator;

    @Inject
    private UserDAO userDAO;

    @Resource
    private Validator validator;

    private String errors = "";


    @Override
    public User create(String login, String password, String firstName, String lastName, UserState state) {

        User user = createUser()
                .withLogin(login)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withState(state).build();

            subjectValidator.validateLogin(login);
            User hereUser = null;

            try {
                hereUser = userDAO.save(user);
            } catch (EJBException ex) {
                errors = propertiesValidator.printErrorMessages(propertiesValidator.validate(user, validator));
            }

            return hereUser;
        }

        public String getErrors(){
            return errors;
        }

        public void setErrors(String errors){
            this.errors = errors;
        }



}
