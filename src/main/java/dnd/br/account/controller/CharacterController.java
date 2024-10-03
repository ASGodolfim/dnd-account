package dnd.br.account.controller;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.config.services.CharacterServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
@Tag(name = "Character", description = "Endpoints for managing characters")
public class CharacterController {

    @Autowired
    private CharacterServices services;


    @PostMapping(value = "/account/c/new")
    @Operation(summary = "Creates new Character", description = "Creates a new Character", tags = "Character")
    public CharacterDTO create(@RequestBody CharacterDTO character) throws Exception {
        return services.create(character);
    }

    @PutMapping(value = "/account/c/{id}")
    @Operation(summary = "Updates a Character", description = "Updates an Existing Character", tags = "Character")
    public CharacterDTO update(@PathVariable(value = "id") Long id,@RequestBody CharacterDTO character) throws Exception {
        return services.update(character);
    }

    @GetMapping(value = "/{username}/c")
    @Operation(summary = "Finds all characters of an account", description = "finds all character of an account by username", tags = "Character")
    public List<CharacterDTO> findByUsername(@PathVariable(value = "username")String username) throws Exception{
        return services.findByAccountUsername(username);
    }

    @GetMapping(value = "/c/{id}")
    @Operation(summary = "Find Character by ID", description = "Finds a character by account id", tags = "Character")
    public CharacterDTO findById(@PathVariable(value = "id") Long id) throws Exception{
        return services.findById(id);
    }

    @GetMapping(value = "/{username}/c/{name}")
    @Operation(summary = "Find Character by Username and character name", description = "Finds a character by username and character name", tags = "Character")
    public CharacterDTO findByUsernameAndName(@PathVariable(value = "username") String username,@PathVariable(value = "name") String name) throws Exception{
        return services.FindByUsernameAndName(username, name);
    }

    @GetMapping(value = "/c")
    @Operation(summary = "Find All Characters", description = "find All Characters Created", tags = "Character")
    public List<CharacterDTO> findAll(){
        return services.findAll();
    }

    @DeleteMapping(value = "/c/{id}")
    @Operation(summary = "Deletes by id", description = "Deletes an existing character by id", tags = "Character")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) throws Exception{

        return services.delete(id);
    }
}
