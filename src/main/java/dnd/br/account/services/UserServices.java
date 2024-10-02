package dnd.br.account.services;

import dnd.br.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws Exception{
        var user = repository.findByUsername(username);
        if (user != null) {
            return user;
        }
    }
}
