package com.codegym.blog_update.models.entities.security;

import javax.persistence.*;
import java.util.List;

@Entity
public class MyUsers {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String passWord;
    private boolean isEnabled;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn (name = "role_id")

    )

    private List< MyRole > myRoles;

    public MyUsers() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List < MyRole > getMyRoles() {
        return myRoles;
    }

    public void setMyRoles(List < MyRole > myRoles) {
        this.myRoles = myRoles;
    }
}
