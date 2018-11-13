package lv.javaguru.java2.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
@SecondaryTable(name = "passwords", pkJoinColumns=@PrimaryKeyJoinColumn(name="id", referencedColumnName="userid"))
public class User {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(table="passwords", name="password1")
    private String password;

    @Column(table="passwords", name="password2", nullable = true)
    private String lastPassword;

    @Column(table="passwords", name="password3", nullable = true)
    private String veryLastPassword;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private UserState state;

    @Override
    public String toString(){
        StringBuilder userString = new StringBuilder();
        userString.append(this.userId + "\n").append(this.firstName + "\n").append(this.lastName + "\n")
                .append(this.login + "\n").append(this.state + "\n");

        return userString.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastPassword() {
        return lastPassword;
    }

    public String getVeryLastPassword() {
        return veryLastPassword;
    }

    public void setLastPassword(String lastPassword) {
        this.lastPassword = lastPassword;
    }

    public void setVeryLastPassword(String veryLastPassword) {
        this.veryLastPassword = veryLastPassword;
    }
}
