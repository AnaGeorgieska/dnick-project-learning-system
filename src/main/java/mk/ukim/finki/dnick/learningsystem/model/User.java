package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String country;

    public User(String username, String password, String name, String surname, String country) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public User() {
    }
}

