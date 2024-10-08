package dnd.br.account.config.services;

import dnd.br.account.controller.UserController;
import dnd.br.account.dto.UserDTO;
import dnd.br.account.entity.User;
import dnd.br.account.exeptions.NotFoundExeption;
import dnd.br.account.exeptions.RequiredObjectIsNullException;
import dnd.br.account.config.map.Mapper;
import dnd.br.account.config.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Autowired
    Mapper mapper;

    private final Logger logger = Logger.getLogger(UserServices.class.getName());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByUsername(username);
        if (user != null) {
            return user;

        } else {
            throw new UsernameNotFoundException("Username " + username + " Not found");
        }
    }

    public UserDTO createUser(UserDTO user) throws Exception{

        if (user == null) throw new RequiredObjectIsNullException();

        logger.info("Creating new User");

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder =
                new Pbkdf2PasswordEncoder(
                        "",
                        8,
                        185000,
                        Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);

        encoders.put("pbkdf2", pbkdf2PasswordEncoder);
        DelegatingPasswordEncoder passwordEncoder =
                new DelegatingPasswordEncoder("pbkdf2", encoders);
        passwordEncoder.setDefaultPasswordEncoderForMatches(passwordEncoder);

        String result = passwordEncoder.encode(user.getPassword());
        user.setPassword(result);

        var entity = Mapper.parseChar(user, User.class);
        entity.setAccountNonExpired(true);
        entity.setAccountNonLocked(true);
        entity.setCredentialsNonExpired(true);
        entity.setEnabled(true);
        var dto = Mapper.parseUser(repository.save(entity), UserDTO.class);
        return dto.add(linkTo(methodOn(UserController.class)).withSelfRel());


    }

    public UserDTO updateUser(UserDTO user) throws  UsernameNotFoundException{

        if (user == null) throw new RequiredObjectIsNullException();

        logger.info("Updating a User");

        var entity = repository.findByUsername(user.getUser_name());

        if (entity == null) throw new NotFoundExeption("Not Found");

        entity.setPassword(user.getPassword());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setAge(user.getAge());

        var dto = Mapper.parseUser(repository.save(entity), UserDTO.class);
        return dto.add(linkTo(methodOn(UserController.class)).withSelfRel());
    }

    public UserDTO findByUsername (String username) throws UsernameNotFoundException{
        User entity = repository.findByUsername(username);
        if (entity == null) throw new NotFoundExeption("User Not Found");
        var dto = Mapper.parseUser(entity, UserDTO.class);
        dto.add(linkTo(methodOn(UserController.class)).withSelfRel());
        return dto;
    }

}
