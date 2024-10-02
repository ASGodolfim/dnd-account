package dnd.br.account.controller;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.security.CharacterServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/character")
@RestController
@Tag(name = "Character", description = "Endpoints for managing characters")
public class CharacterController {

    @Autowired
    private CharacterServices services;


    @PostMapping(value = "/new")
    @Operation(summary = "Creates new Character", description = "Creates a new Character", tags = "Character")
    public CharacterDTO create(@RequestBody CharacterDTO character){
        return services.create(character);
    }

    @GetMapping(value = "/{username}")
    @Operation(summary = "Finds all characters of an account", description = "finds all character of an account by username", tags = "Character")
    public List<CharacterDTO> findByUsername(@PathVariable(value = "username")String username) throws Exception{
        return services.findByUsername(username);
    }

    @GetMapping(value = "/{name}")
    @Operation(summary = "Find Character by Name", description = "Finds a character by name", tags = "Character")
    public CharacterDTO findById(@PathVariable(value = "name") String name) throws Exception{
        return services.findByName(name);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find Character by ID", description = "Finds a character by account id", tags = "Character")
    public CharacterDTO findById(@PathVariable(value = "id") Long id) throws Exception{
        return services.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletes by id", description = "Deletes an existing character by id", tags = "Character")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) throws Exception{
        return services.delete(id);
    }
}
