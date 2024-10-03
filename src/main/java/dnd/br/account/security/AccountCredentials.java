package dnd.br.account.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class AccountCredentials {

    private String username;
    private String password;

    public AccountCredentials(String username, String password){
        this.username = username;
        this.password = password;
    }

    public AccountCredentials() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCredentials that = (AccountCredentials) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
