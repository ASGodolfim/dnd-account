package dnd.br.account.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/character")
@RestController
@Tag(name = "Character", description = "Endpoints for managing characters")
public class CharacterController {
}
