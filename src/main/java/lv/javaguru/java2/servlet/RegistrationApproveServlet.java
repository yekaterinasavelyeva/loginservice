package lv.javaguru.java2.servlet;

import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.exceptions.UserPropertyException;
import lv.javaguru.java2.services.user.EditUserService;
import lv.javaguru.java2.services.user.UserFactory;

import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user
 * on 25.03.2019
 */

public class RegistrationApproveServlet extends HttpServlet {

    @Inject
    private UserFactory service;

    private List <String> errors;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String firstname = req.getParameter("firstname");
        String lastname  = req.getParameter("lastname");
        errors = new ArrayList<>();

        try {
            service.create(login, password2, firstname, lastname, UserState.VISITOR);
        } catch (EJBTransactionRolledbackException e){
            errors.add(e.getMessage());
        }
            if(!service.getErrors().isEmpty() || !password1.equals(password2)){
                if(!password1.equals(password2)) {
                    errors.add("Warning! Passwords Mismatch. Try again!");
                }
                errors.addAll(Arrays.asList(service.getErrors().split("\n")));
                req.setAttribute("errors", errors);
                service.setErrors("");
                getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);

            } else {

                req.setAttribute("name", firstname + " " + lastname);
                getServletContext().getRequestDispatcher("/approve.jsp").forward(req, resp);
            }


    }
}
