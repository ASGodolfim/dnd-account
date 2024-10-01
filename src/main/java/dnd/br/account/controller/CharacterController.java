package dnd.br.account.controller;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.security.CharacterServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find Character by ID", description = "Finds a character by account username and id", tags = "Character")
    public CharacterDTO findById(@PathVariable(value = "id") Long id) throws Exception{
        return services.findById(id);
    }
}
