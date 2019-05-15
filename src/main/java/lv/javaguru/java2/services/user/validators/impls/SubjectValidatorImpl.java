package lv.javaguru.java2.services.user.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.exceptions.UserPropertyException;
import lv.javaguru.java2.services.user.validators.SubjectValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by user
 * on 12.03.2019
 */
@Stateless
@Named
public class SubjectValidatorImpl implements SubjectValidator {

    @Inject
    private UserDAO dao;

    @Override
    public void validateLogin(String login) {
        if(dao.getByLogin(login).isPresent()) {
            throw new UserPropertyException("Login already exists. Try another one!");
        }
    }


    @Override
    public void validatePassword(String password, User user) {
        if(dao.getAllPasswords(user.getUserId()).stream().anyMatch(i -> i.equals(password))){
               throw  new UserPropertyException("Password has to be different than previous ones!");
        }
    }
}
