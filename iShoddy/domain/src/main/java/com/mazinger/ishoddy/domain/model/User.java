package com.mazinger.ishoddy.domain.model;

public class User {


    private String name;
    private String lastname;
    private String token;
    private String id;
    private String email;
    private String password;
    private Number telephone;


    public static User of(String email, String id){
        User user = new User();

        user.email = email;
        user.id = id;

        return user;
    }

    private User() {}

    // Singleton
    public static User userInstance;

    public static User getInstance() {
        if  (userInstance == null){
            userInstance = new User();
        }
        return userInstance;
    }


    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getToken() {
        return token;
    }

    public User setToken(String token) {
        this.token = token;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Number getTelephone() {
        return telephone;
    }

    public User setTelephone(Number telephone) {
        this.telephone = telephone;
        return this;
    }

    public static User getUserInstance() {
        return userInstance;
    }

    public static void setUserInstance(User userInstance) {
        User.userInstance = userInstance;
    }
}
