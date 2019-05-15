package lv.javaguru.java2.services.user.impls;

public class EditUserServiceImpl  {

    /*private UserDAO userDAO = new UserDAOImpl();
    private UserEditValidator userEditValidator =
            new UserEditValidatorImpl();

    @Override
    public void edit(Long userId, String firstName, String lastname, UserState state) {
        Optional<User> userOpt = userDAO.getById(userId);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("User not found by id = " + userId);
        }

        User user = userOpt.get();
        userEditValidator.validate(firstName, lastname, state);
        user.setFirstName(firstName);
        user.setLastName(lastname);
        user.setState(state);
        userDAO.update(user);
    }*/

}
