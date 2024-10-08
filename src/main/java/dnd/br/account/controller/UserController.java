package dnd.br.account.controller;

import dnd.br.account.dto.UserDTO;
import dnd.br.account.entity.User;
import dnd.br.account.config.services.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "User", description = "Endpoints for Users")
public class UserController {

    @Autowired
    UserServices services;

    @PostMapping(value = "/new")
    @Operation(summary = "Creates a new User", description = "Creates a new User", tags = "User")
    public UserDTO createUser (@RequestBody UserDTO user) throws Exception {
        return services.createUser(user);
    }

    @PutMapping(value = "api/u/{id}")
    @Operation(summary = "Updates a User", description = "Updates an exisisting user", tags = "User")
    public UserDTO updateUser (@RequestBody UserDTO user, @PathVariable(value = "id") Long id) throws Exception{
        return services.updateUser(user);
    }

    @GetMapping(value = "api/u/{username}")
    @Operation(summary = "Finds a user by Username", description = "Finds a exisiting user", tags = "User")
    public UserDTO findByUsername (@PathVariable(value = "username") String username) throws Exception {
        return services.findByUsername(username);
    }

}
