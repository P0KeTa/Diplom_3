package ru.poketa.stellar.burgers.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public String email;
    public String password;
    public String name;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
}
