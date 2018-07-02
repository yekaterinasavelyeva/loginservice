package lv.javaguru.java2.domain;

public class Account {

    private Long accountId;

    private String firstName;

    private String lastName;

    private AccountState state;


    //Getters and setters
    
    public Long getAccountId() {
        return accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AccountState getState() {
        return state;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setState(AccountState state) {
        this.state = state;
    }
}
