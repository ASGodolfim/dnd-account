package dnd.br.account.config.services;

import dnd.br.account.config.repository.UserRepository;
import dnd.br.account.security.AccountCredentials;
import dnd.br.account.security.Token;
import dnd.br.account.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    public ResponseEntity signIn(AccountCredentials data) {
        try {
            var username = data.getUsername();
            var password = data.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            
            var user = repository.findByUsername(username);

            Token tokenResponse = new Token();
            if (user != null) {
                tokenResponse = tokenProvider.createAceessToken(username, user.getRoles());
                System.out.println(tokenResponse);
            } else {
                throw new UsernameNotFoundException("Username " + username + " not found");
            }
            return ResponseEntity.ok(tokenResponse);

        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password");
        }
    }
}
