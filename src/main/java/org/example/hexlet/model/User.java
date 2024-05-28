package org.example.hexlet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Long id;

    @ToString.Include
    //private String firstName;
    private String name;
    private String mail;
    private String password;

    public User(String name, String mail, String password) {
        //this.firstName = firstName;
        this.name = name;
        this.mail = mail;
        this.password = password;
    }
}
