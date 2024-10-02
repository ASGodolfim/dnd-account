package dnd.br.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {

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

    public User(Long id, String userName, String password, String name, String email, Integer age, boolean b, boolean b1, boolean b2, boolean b3) {
    }

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


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_character", joinColumns = {@JoinColumn(name = "user_name")},
            inverseJoinColumns = {@JoinColumn(name = "account_username")})
    private List<Character> names;

    public List<String> name(){
        List<String> characterName = new ArrayList<>();
        for (Character character:names){
            characterName.add(character.getName());
        }
        return characterName;


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }

    public User(Long id, String user_name, String password, String name, String email, Integer age, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled, List<Character> names) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.names = names;
    }

    
}
