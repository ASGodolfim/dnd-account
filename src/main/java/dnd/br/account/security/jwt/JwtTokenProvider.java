package dnd.br.account.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import dnd.br.account.exeptions.InvalidJwtAuthenticationException;
import dnd.br.account.security.Token;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Repository
public class JwtTokenProvider {

    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey = "secret";

    Algorithm algorithm = null;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostConstruct
    protected void init(){

        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        algorithm = Algorithm.HMAC256(secretKey.getBytes());
    }

    public Token createAceessToken(String username, List<String> roles){
        var token = new Token();
        var now = new Date();
        token.setUsername(username);
        token.setAuthenticated(true);
        token.setCreated(now);
        token.setAccessToken(getAccessToken(username, roles, now));
        return token;
    }

    private String getAccessToken(String username, List<String> roles, Date now){
        String issuerUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath().build().toUriString();
        return JWT.create()
                .withClaim("roles", roles)
                .withIssuedAt(now)
                .withSubject(username)
                .withIssuer(issuerUrl)
                .sign(algorithm)
                .strip();
    }

    public Authentication getAuthentication(String token){
        DecodedJWT decodedJWT = decodedToken(token);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(decodedJWT.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private DecodedJWT decodedToken(String token){
        Algorithm algorithmDecoder = Algorithm.HMAC256(secretKey.getBytes());
        JWTVerifier verifier = JWT.require(algorithmDecoder).build();
        return verifier.verify(token);
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }

    public boolean validateToken(String token) throws InvalidJwtAuthenticationException{
        DecodedJWT decodedJWT = decodedToken(token);
        try {
            if (decodedJWT.getExpiresAt().before(new Date())){
                return false;
            }
            return true;
        } catch (Exception e){
            throw new InvalidJwtAuthenticationException("Invalid Token");
        }
    }
}
