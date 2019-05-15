package lv.javaguru.java2.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by user
 * on 22.03.2019
 */

@Entity
@Table(name = "sessions")
public class Session implements Serializable {

    private static final long serialVersionUID = -5706689714326132798L;

    @NotNull
    @Id
    @Column(name = "session_id")
    private String sessionId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User authUser;

    public Session(User user, String sessionId){
        this.authUser = user;
        this.sessionId = sessionId;
    }

    public Session(){}

    public User getUser() {
        return authUser;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setUser(User user) {
        this.authUser = user;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
