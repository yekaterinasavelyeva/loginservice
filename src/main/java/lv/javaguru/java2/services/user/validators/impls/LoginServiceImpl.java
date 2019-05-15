package lv.javaguru.java2.services.user.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.user.validators.LoginService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by user
 * on 17.04.2019
 */

@Stateless
public class LoginServiceImpl implements LoginService {

    @Inject
    private UserDAO dao;

    @Override
    public String login(String login, String password) {
        Optional<User> user = dao.getByLogin(login);
        if(user.isPresent()){
            if(user.get().getPassword().equals(password)){
                return "success";
            } else {
                return "password incorrect";
            }
        } else {
            return "fail";
        }
    }
}
