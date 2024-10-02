package dnd.br.account.security;

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
        var dto = Mapper.parseObj(repository.save(entity), CharacterDTO.class);
        return dto;
    }

    public CharacterDTO findById (Long id){

        logger.info("Find a character by name");

        var entity = repository.findById(id).orElseThrow();
        CharacterDTO dto = Mapper.parseObj(entity, CharacterDTO.class);
        return dto;
    }

    public List<CharacterDTO> findByUsername (String name){

        logger.info("Find a characters of an account by username");

        var entity = repository.findByUserame(name);
        List<CharacterDTO> dto = Mapper.parseListObj(entity, CharacterDTO.class);
        return dto;
    }

    public ResponseEntity delete (Long id){

        logger.info("Deleting a character by id");

        var entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
        return ResponseEntity.noContent().build();
    }





}
