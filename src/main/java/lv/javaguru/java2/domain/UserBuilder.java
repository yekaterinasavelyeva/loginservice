package lv.javaguru.java2.domain;

public class UserBuilder {

    private String login;
    private String password;


    private UserBuilder() {}

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public User build() {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }

    public UserBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

}
