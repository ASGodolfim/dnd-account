package dnd.br.account.security;

import dnd.br.account.controller.CharacterController;
import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import dnd.br.account.map.CharacterMapper;
import dnd.br.account.map.Mapper;
import dnd.br.account.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CharacterServices {

    @Autowired
    CharacterRepository repository;

    @Autowired
    CharacterMapper mapper;

    private Logger logger = Logger.getLogger(CharacterServices.class.getName());


    public CharacterDTO create (CharacterDTO character){


        logger.info("Creating new Character");

        var entity = Mapper.parseObj(character, Character.class);
        var dto = new CharacterDTO();
        if (!dto.getMulticlass()) {dto.setCharacterMulticlass(null);dto.setMulticlassSubclass(null);dto.setMulticlassLevel(0);}

        dto.setCharacterLevel(dto.getClassLevel()+dto.getMulticlassLevel());

        int conmodifier = -1;
        switch (dto.getConstitution()){
            case 10:
                conmodifier = 0;
                break;
            case 12:
                conmodifier = 1;
                break;
            case 14:
                conmodifier = 2;
                break;
            case 16:
                conmodifier = 3;
                break;
            case 18:
                conmodifier = 4;
                break;
            case 20:
                conmodifier = 5;
                break;
            default:
        }
        dto.setLife(8 + conmodifier + ((dto.getCharacterLevel() - 1) * (5+conmodifier)));

        Mapper.parseObj(repository.save(entity), CharacterDTO.class);

        return dto;
    }

    public CharacterDTO findById (Long id){

        logger.info("Find a character by id");

        var entity = repository.findById(id).orElseThrow();
        return Mapper.parseObj(entity, CharacterDTO.class);
    }

    public CharacterDTO findByName (String name){

        logger.info("Find a character by name");

        var entity = repository.findByName(name);
        return Mapper.parseObj(entity, CharacterDTO.class);
    }

    public List<CharacterDTO> findByAccountUsername (String accountUsername){

        logger.info("Find all characters of an account by username");

        return Mapper.parseListObj(repository.findAll(), CharacterDTO.class).stream().filter(c -> c.getAccountUsername().equals(accountUsername))
                .collect(Collectors.toList());
    }

    public List<CharacterDTO> findAll(){

        logger.info("Finding all the Characters!");

        return Mapper.parseListObj(repository.findAll(), CharacterDTO.class);
    }

    public ResponseEntity delete (Long id){

        logger.info("Deleting a character by id");

        var entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
        return ResponseEntity.noContent().build();
    }
}
