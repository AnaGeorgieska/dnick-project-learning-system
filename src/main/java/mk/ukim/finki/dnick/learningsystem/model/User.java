package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "app_users")
public class User implements UserDetails {

    @Id
    private String username;
    private String password;
    private String name;
    private String surname;
    private String country;

    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String name, String surname, String username, String password, String country) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role=Role.ROLE_USER;
        this.country = country;
    }

    public User(String username, String password, String name, String surname, Role role, String country) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.role=role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getCountry() {
        return country;
    }
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}

