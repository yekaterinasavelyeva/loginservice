package lv.javaguru.java2.services.user.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserBuilder;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.user.UserFactory;
import lv.javaguru.java2.services.user.impls.UserFactoryImpl;
import lv.javaguru.java2.services.user.validators.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by user
 * on 17.04.2019
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

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

    @InjectMocks
    private LoginService service = new LoginServiceImpl();


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
        when(userDAO.getByLogin("savelyeva")).thenReturn(Optional.of(user1));
        service.login("savelyeva", "Savelyeva1");
        InOrder inOrder = Mockito.inOrder(userDAO);
        inOrder.verify(userDAO).getByLogin(any(String.class));
    }

    @Test
    public void loginUserTest(){
        when(userDAO.getByLogin("savelyevasa")).thenReturn(Optional.of(user2));
        String status = service.login("savelyevasa", "Savelyeva2");
        assertEquals(status, "success");
    }

}