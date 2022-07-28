package com.situ.web.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String tel;

    public User() {
    }

    public User(int id, String username, String password, String email, String tel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tel = tel;
    }

    public User(String username, String password, String email, String tel) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
