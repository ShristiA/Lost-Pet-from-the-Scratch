package com.example.demo;


import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name="User_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column (name="password")
    private String password;

    @Column(name="first name")
    private String firstname;

    @Column(name="last_name")
    private String lastName;

    @Column(name= "enabled")
    private boolean enabled;

    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name= "role_id"))
    private Collection<Role> roles;

    public User(){
        roles = new HashSet<>();

    }

    public User(String email, String password, String firstname, String lastName, boolean enabled, String username) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastName = lastName;
        this.enabled = enabled;
        this.username = username;
        roles = new HashSet<>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
