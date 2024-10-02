package dnd.br.account.security;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import dnd.br.account.map.CharacterMapper;
import dnd.br.account.map.Mapper;
import dnd.br.account.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public CharacterDTO update (CharacterDTO character){

        logger.info("Updating one Person");

        Character entity;
        entity = repository.findById(character.getId()).orElseThrow();

        entity.setName(character.getName());
        entity.setCharacterClass(character.getCharacterClass());
        entity.setSubclass(character.getSubclass());
        entity.setClassLevel(character.getClassLevel());
        entity.setStrength(character.getStrength());
        entity.setConstitution(character.getConstitution());
        entity.setDexterity(character.getDexterity());
        entity.setWisdom(character.getWisdom());
        entity.setIntelligence(character.getIntelligence());
        entity.setCharisma(character.getCharisma());
        entity.setMulticlass(character.getMulticlass());
        entity.setCharacterMulticlass(character.getCharacterMulticlass());
        entity.setMulticlassSubclass(character.getMulticlassSubclass());
        entity.setMulticlassLevel(character.getMulticlassLevel());
        entity.setArmorClass(character.getArmorClass());
        entity.setGold(character.getGold());
        entity.setArmor(character.getArmor());
        entity.setWeapon(character.getWeapon());
        entity.setTreasure(character.getTreasure());

        if (!entity.getMulticlass()) {entity.setCharacterMulticlass(null);entity.setMulticlassSubclass(null);entity.setMulticlassLevel(0);}

        entity.setCharacterLevel(entity.getClassLevel() + entity.getMulticlassLevel());

        int conmodifier = -1;
        switch (entity.getConstitution()){
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
        entity.setLife(8 + conmodifier + ((entity.getCharacterLevel() - 1) * (5+conmodifier)));
        return Mapper.parseObj(repository.save(entity), CharacterDTO.class);
    }

    public CharacterDTO findById (Long id){

        logger.info("Find a character by id");

        var entity = repository.findById(id).orElseThrow();
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
