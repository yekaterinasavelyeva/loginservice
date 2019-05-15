package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserBuilder;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.user.UserFactory;
import lv.javaguru.java2.services.user.validators.DataInputValidator;
import lv.javaguru.java2.services.user.validators.SubjectValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by user
 * on 21.03.2019
 */

@RunWith(MockitoJUnitRunner.class)
public class UserFactoryImplTest {

    private static final String LOGIN = "logi@";
    private static final String PASSWORD = "Password2";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private List<User> users;
    private User user1;
    private User user2;
    private User user3;

    @Mock
    private UserDAO userDAO;
    @Mock
    private SubjectValidator subjectValidator;
    @Mock
    private DataInputValidator dataValidator;
    @Mock
    private Validator validator;

    @InjectMocks
    private UserFactory service = new UserFactoryImpl();


        @Before
        public void setUp() throws Exception {
            users = new ArrayList<>();
            user1 = UserBuilder.createUser().withFirstName("Yekaterina").withLastName("Savelyeva").withLogin("savelyeva").withPassword("Savelyeva1").withState(UserState.ADMIN).build();
            user2 = UserBuilder.createUser().withFirstName("Yulia").withLastName("Sisoyeva").withLogin("savelyevasa").withPassword("Savelyeva2").withState(UserState.VISITOR).build();
            user3 = UserBuilder.createUser().withFirstName("Anna").withLastName("Bruseva").withLogin("annaanna").withPassword("Bruseva6").withState(UserState.VISITOR).build();
            Collections.addAll(users, user1, user2, user3);
        }

    @Test
    public void checkServiceMethodsOrder() {
        service.create(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, UserState.ADMIN);
        InOrder inOrder = Mockito.inOrder(dataValidator,subjectValidator, userDAO);
        inOrder.verify(subjectValidator).validateLogin(LOGIN);
        inOrder.verify(userDAO).save(any(User.class));
    }

    @Test
    public void saveUserTest() {
            when(userDAO.save(user1)).thenReturn(user1);
            User user = userDAO.save(user1);
            assertEquals(user, user1);
    }
}