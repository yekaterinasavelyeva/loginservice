package lv.javaguru.java2.domain;

import javax.persistence.*;

/**
 * Created by Yekaterina Savelyeva
 * on 15.10.2018
 */

@Entity
@Table(name = "users")

public class Userxxx {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long userId;

        @Column(unique = true)
        private String login;

        private String password;

        private String firstName;

        private String lastName;

        @Enumerated(EnumType.STRING)
        private UserState state;

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


}
