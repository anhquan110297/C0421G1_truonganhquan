package com.codegym.blog_update.models.entities.security;

import com.codegym.blog_update.models.entities.security.MyUsers;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MyRole {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany (mappedBy = "myRoles")
    private Set< MyUsers > users;

    public MyRole() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set < MyUsers > getUsers() {
        return users;
    }

    public void setUsers(Set < MyUsers > users) {
        this.users = users;
    }
}
