package lv.javaguru.java2.services.user.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.user.EditUserService;
import lv.javaguru.java2.services.validators.UserEditValidator;
import lv.javaguru.java2.services.validators.impls.UserEditValidatorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EditUserServiceImplTest {

    private static final Long EXAMPLE_LONG = 1234L;
    private static final String EXAMPLE_STRING = "example";
    private static final UserState EXAMPLE_STATE = UserState.VISITOR;

    @Mock
    private UserDAO userDAO ;
    @Mock
    private UserEditValidator validator;
    @InjectMocks
    private EditUserService service = new EditUserServiceImpl();

    @Test
    public void checkEditMethodsOrder(){
        User user = Mockito.mock(User.class);
        when(userDAO.getById(EXAMPLE_LONG)).thenReturn(Optional.of(user));
        InOrder inOrder = Mockito.inOrder(user, validator, userDAO);
        service.edit(EXAMPLE_LONG, EXAMPLE_STRING, EXAMPLE_STRING, EXAMPLE_STATE);

        inOrder.verify(userDAO).getById(EXAMPLE_LONG);
        inOrder.verify(validator).validate(EXAMPLE_STRING, EXAMPLE_STRING, EXAMPLE_STATE);
        inOrder.verify(userDAO).update(user);
    }

}