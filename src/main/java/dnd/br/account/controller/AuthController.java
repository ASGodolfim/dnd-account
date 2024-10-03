package dnd.br.account.controller;

import dnd.br.account.config.services.AuthServices;
import dnd.br.account.security.AccountCredentials;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication Endpoint")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthServices authServices;

    private boolean checkIfParamsIsNotNull (AccountCredentials data){
        return data == null || data.getUsername() == null || data.getUsername().isBlank() || data.getPassword() == null || data.getPassword().isBlank();
    }

    @PostMapping(value = "/singin")
    @Operation(summary = "Authenticates a user and returns a token")
    public ResponseEntity signIn(@RequestBody AccountCredentials data){
        if (checkIfParamsIsNotNull(data))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Username or Password");
        var token = authServices.signIn(data);
        if (token == null) return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Username or Password");
        else
            return token;
    }

}
