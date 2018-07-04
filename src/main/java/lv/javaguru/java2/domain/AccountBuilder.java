package lv.javaguru.java2.domain;

public class AccountBuilder {

    private String firstName;
    private String lastName;
    private AccountState state;


    private AccountBuilder() {}

    public static AccountBuilder createAccount() {
        return new AccountBuilder();
    }

    public Account build() {
        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setState(state);
        return account;
    }

    public AccountBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AccountBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccountBuilder withStatus(AccountState state) {
        this.state = state;
        return this;
    }
}
