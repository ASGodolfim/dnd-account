package dnd.br.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 40, unique = true)
    private String user_name;

    @Column(nullable = false,length = 40)
    private String password;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer age;

    @Column(name = "account_non_expired",nullable = false)
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked",nullable = false)
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired",nullable = false)
    private Boolean credentialsNonExpired;

    @Column(nullable = false)
    private Boolean enabled;

    public User(){}

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "character", joinColumns = {@JoinColumn(name = "username")},
            inverseJoinColumns = {@JoinColumn(name = "account_username")})
    private List<Character> names;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(user_name, user.user_name) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(age, user.age) && Objects.equals(accountNonExpired, user.accountNonExpired) && Objects.equals(accountNonLocked, user.accountNonLocked) && Objects.equals(credentialsNonExpired, user.credentialsNonExpired) && Objects.equals(enabled, user.enabled) && Objects.equals(names, user.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_name, password, name, email, age, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, names);
    }

    public List<String> getNames(){
        List<String> characters = new ArrayList<>();
        for (Character character:names){
            characters.add(character.getName());
        }
        return characters;



    }
}
