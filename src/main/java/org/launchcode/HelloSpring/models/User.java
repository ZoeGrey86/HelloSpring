package org.launchcode.HelloSpring.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User extends AbstractEntity {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Size(min = 5, max = 15, message = "user name must be between 5 and 15 characters")
    public String username;

    @NotBlank(message = "password required")
    @Size(min = 6)
    public String pwHash;

    public User(){}

    public User(String username, String password){
        super();
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }


    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}
