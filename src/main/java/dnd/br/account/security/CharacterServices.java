package dnd.br.account.security;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import dnd.br.account.map.CharacterMapper;
import dnd.br.account.map.Mapper;
import dnd.br.account.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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





}
