package dnd.br.account.config.services;

import dnd.br.account.config.repository.UserRepository;
import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import dnd.br.account.exeptions.NotFoundExeption;
import dnd.br.account.exeptions.RequiredObjectIsNullException;
import dnd.br.account.config.map.Mapper;
import dnd.br.account.config.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CharacterServices {

    @Autowired
    CharacterRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Mapper mapper;

    private final Logger logger = Logger.getLogger(CharacterServices.class.getName());

    public CharacterDTO create (CharacterDTO character) throws Exception{

        if (character == null) throw new RequiredObjectIsNullException();

        logger.info("Creating new Character");

        var entity = Mapper.parseChar(character, Character.class);

        if (!entity.getMulticlass() || entity.getMulticlass() == null) {entity.setMulticlass(false);entity.setCharacterMulticlass(null);entity.setMulticlassSubclass(null);entity.setMulticlassLevel(0);}

        entity.setCharacterLevel(entity.getClassLevel()+entity.getMulticlassLevel());

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

        var dto = new CharacterDTO();
        dto = Mapper.parseChar(repository.save(entity), CharacterDTO.class);

        return dto;
    }

    public CharacterDTO update (CharacterDTO character) throws Exception{

        if (character == null) throw new RequiredObjectIsNullException();
        
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

        if (!entity.getMulticlass() || entity.getMulticlass() == null) {entity.setMulticlass(false);entity.setCharacterMulticlass(null);entity.setMulticlassSubclass(null);entity.setMulticlassLevel(0);}

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
        return Mapper.parseChar(repository.save(entity), CharacterDTO.class);
    }

    public CharacterDTO findById (Long id) throws Exception {

        logger.info("Find a character by id");

        var entity = repository.findById(id).orElseThrow(() -> new NotFoundExeption("Nothing Found"));
        return Mapper.parseChar(entity, CharacterDTO.class);
    }

    public CharacterDTO FindByUsernameAndName(String username, String name) throws Exception{
        Character entity = repository.findByUsernameAndName(username, name);
        if (entity == null) throw new NotFoundExeption("Nothing Found");
        return Mapper.parseChar(entity, CharacterDTO.class);
    }


    public Page<CharacterDTO> findByAccountUsername (String accountUsername, Pageable pageable) {

        logger.info("Find all characters of an account by username");

        List<Character> characters = repository.findAll().stream().filter(c -> c.getAccountUsername().equals(accountUsername)).toList();;
        var charPageDto = Mapper.parseListChar(characters, CharacterDTO.class);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), charPageDto.size());
        List<CharacterDTO> pageContent = charPageDto.subList(start, end);
        return new PageImpl<>(pageContent, pageable, charPageDto.size());
    }

    public Page<CharacterDTO> findAll(Pageable pageable){

        logger.info("Finding all the Characters!");

        var charPage = repository.findAll(pageable);

        return charPage.map(c -> Mapper.parseChar(c, CharacterDTO.class));
    }

    public ResponseEntity delete (Long id){

        logger.info("Deleting a character by id");

        var entity = repository.findById(id).orElseThrow(() -> new NotFoundExeption("Nothing Found"));

        repository.delete(entity);
        return ResponseEntity.noContent().build();
    }
}
