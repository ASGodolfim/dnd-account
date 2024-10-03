package dnd.br.account.services;

import dnd.br.account.controller.UserController;
import dnd.br.account.dto.UserDTO;
import dnd.br.account.entity.User;
import dnd.br.account.exeptions.NotFoundExeption;
import dnd.br.account.exeptions.RequiredObjectIsNullException;
import dnd.br.account.map.Mapper;
import dnd.br.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.logging.Logger;

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

        var entity = Mapper.parseObj(user, User.class);
        var dto = new UserDTO();
        dto = Mapper.parseObj(repository.save(entity), UserDTO.class);
        dto.add(linkTo(methodOn(UserController.class)).withSelfRel());
        return dto;

    }

    public UserDTO updateUser(UserDTO user) throws  Exception{

        if (user == null) throw new RequiredObjectIsNullException();

        logger.info("Updating a User");

        var entity = repository.findById(user.getId()).orElseThrow();

        entity.setPassword(user.getPassword());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setAge(user.getAge());

        var dto = Mapper.parseObj(repository.save(entity), UserDTO.class);
        dto.add(linkTo(methodOn(UserController.class)).withSelfRel());
        return dto;
    }

    public User findByUsername (String username) throws Exception{
        User entity = repository.findByUsername(username);
        if (entity == null) throw new NotFoundExeption("User Not Found");
        var dto = Mapper.parseObj(entity, UserDTO.class);
        dto.add(linkTo(methodOn(UserController.class)).withSelfRel());
        return entity;
    }

}
