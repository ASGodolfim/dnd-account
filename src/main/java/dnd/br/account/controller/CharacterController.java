package dnd.br.account.controller;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.config.services.CharacterServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpHeaders;
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

    @GetMapping(value = "/{username}/c")
    @Operation(summary = "Finds all characters of an account", description = "finds all character of an account by username", tags = "Character")
    public ResponseEntity<PagedModel<EntityModel<CharacterDTO>>> findByUsername(
            @PathVariable(value = "username")String username,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "5") Integer size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) throws Exception{

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));

        return ResponseEntity.ok(services.findByAccountUsername(username, pageable));
    }

    @GetMapping(value = "/c")
    @Operation(summary = "Find All Characters", description = "find All Characters Created", tags = "Character")
    public ResponseEntity<PagedModel<EntityModel<CharacterDTO>>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "5") Integer size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction){

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));

        return ResponseEntity.ok(services.findAll(pageable));
    }

    @DeleteMapping(value = "/c/{id}")
    @Operation(summary = "Deletes by id", description = "Deletes an existing character by id", tags = "Character")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) throws Exception{
        return services.delete(id);
    }
}
