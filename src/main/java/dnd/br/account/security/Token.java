package dnd.br.account.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class Token {

    private String username;
    private Boolean authenticated;
    private Date created;
    private String accessToken;

    public Token() {}

    public Token(String username, Boolean authenticated, Date created, String accessToken) {
        this.username = username;
        this.authenticated = authenticated;
        this.created = created;
        this.accessToken = accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(username, token.username) && Objects.equals(authenticated, token.authenticated) && Objects.equals(created, token.created) && Objects.equals(accessToken, token.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, authenticated, created, accessToken);
    }
}
