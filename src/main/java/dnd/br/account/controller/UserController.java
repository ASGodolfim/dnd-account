package dnd.br.account.controller;

import dnd.br.account.dto.UserDTO;
import dnd.br.account.services.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/u")
@RestController
@Tag(name = "User", description = "Endpoints for Users")
public class UserController {

    @Autowired
    UserServices services;

    @PutMapping(value = "new")
    @Operation(summary = "Creates a new User", description = "Creates a new User", tags = "User")
    public UserDTO createUser (@RequestBody UserDTO user) throws Exception {
        return services.createUser(user);
    }


}
