package dnd.br.account.config.services;

import dnd.br.account.config.repository.UserRepository;
import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import dnd.br.account.exeptions.NotFoundExeption;
import dnd.br.account.exeptions.RequiredObjectIsNullException;
import dnd.br.account.config.map.Mapper;
import dnd.br.account.config.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if (!checkClassSubclass(entity)) throw new IllegalArgumentException("Invalid Class or Subclass");
        if (!checkMulticlassSubclass(entity)) throw new IllegalArgumentException("Invalid Multiclass or Multiclass Subclass");
        entity.setCharacterLevel(entity.getClassLevel() + entity.getMulticlassLevel());
        if (entity.getCharacterLevel()<1 || entity.getCharacterLevel()>20) throw new IllegalArgumentException("Level Under Minimum or Over Maximum");

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
        var user = entity;
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

        if (!checkClassSubclass(entity)) throw new IllegalArgumentException("Invalid Class or Subclass");

        if (!checkMulticlassSubclass(entity)) throw new IllegalArgumentException("Invalid Multiclass or Multiclass Subclass");

        entity.setCharacterLevel(entity.getClassLevel() + entity.getMulticlassLevel());
        if (entity.getCharacterLevel()<1 || entity.getCharacterLevel()>20) throw new IllegalArgumentException("Level Under Minimum or Over Maximum");

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
        String user = entity.getName();
        var dto = Mapper.parseChar(repository.save(entity), CharacterDTO.class);
        return dto;
    }

    public CharacterDTO findById (Long id) throws Exception {

        logger.info("Find a character by id");

        var entity = repository.findById(id).orElseThrow(() -> new NotFoundExeption("Nothing Found"));
        CharacterDTO dto = Mapper.parseChar(entity, CharacterDTO.class);
        return dto;
    }

    public CharacterDTO FindByUsernameAndName(String username, String name) throws Exception{
        Character entity = repository.findByUsernameAndName(username, name);
        if (entity == null) throw new NotFoundExeption("Nothing Found");
        var dto = Mapper.parseChar(entity, CharacterDTO.class);
        return dto;
    }

    public List<CharacterDTO> findByAccountUsername (String accountUsername) {

        logger.info("Find all characters of an account by username");

        var chars = Mapper.parseListChar(repository.findAll(), CharacterDTO.class).stream().filter(c -> c.getAccountUsername().equals(accountUsername)).collect(Collectors.toList());
        return chars;
    }

    public List<CharacterDTO> findAll(){

        logger.info("Finding all the Characters!");

        var chars = Mapper.parseListChar(repository.findAll(), CharacterDTO.class);
        return chars;
    }

    public ResponseEntity delete (Long id){

        logger.info("Deleting a character by id");

        var entity = repository.findById(id).orElseThrow(() -> new NotFoundExeption("Nothing Found"));

        repository.delete(entity);
        return ResponseEntity.noContent().build();
    }




    private boolean checkClassSubclass (Character character) {

        List<String> artificer = new ArrayList<>();
        artificer.add("Alchemist");
        artificer.add("Armorer");
        artificer.add("Artillerist");
        artificer.add("Battle Smith");

        List<String> barbarian = new ArrayList<>();
        barbarian.add("Berserker");
        barbarian.add("Storm Herald");
        barbarian.add("Totem Warriror");
        barbarian.add("Wild Magic");

        List<String> bard = new ArrayList<>();
        bard.add("Lore");
        bard.add("Swords");
        bard.add("Valor");
        bard.add("Glamour");

        List<String> cleric = new ArrayList<>();
        cleric.add("Life");
        cleric.add("Twilight");
        cleric.add("Grave");
        cleric.add("Tempest");

        List<String> druid = new ArrayList<>();
        druid.add("Moon");
        druid.add("Dreams");
        druid.add("Spores");
        druid.add("Stars");

        List<String> fighter = new ArrayList<>();
        fighter.add("Battle Master");
        fighter.add("Echo Knight");
        fighter.add("Rune Knight");
        fighter.add("Samurai");

        List<String> monk = new ArrayList<>();
        monk.add("Astral Self");
        monk.add("Drunken Master");
        monk.add("Four Elements");
        monk.add("Open Hand");

        List<String> paladin = new ArrayList<>();
        paladin.add("Ancients");
        paladin.add("Conquest");
        paladin.add("Glory");
        paladin.add("Oathbreaker");

        List<String> ranger = new ArrayList<>();
        ranger.add("Beast Master");
        ranger.add("Gloom Stalker");
        ranger.add("Hunter");
        ranger.add("Swarmkeeper");

        List<String> rogue = new ArrayList<>();
        rogue.add("Arcane Trickster");
        rogue.add("Assassin");
        rogue.add("Mastermind");
        rogue.add("Phantom");

        List<String> sorcerer = new ArrayList<>();
        sorcerer.add("Draconic Bloodline");
        sorcerer.add("Divine Soul");
        sorcerer.add("Shadow Magic");
        sorcerer.add("Storm Sorcery");

        List<String> warlock = new ArrayList<>();
        warlock.add("Archfey");
        warlock.add("Fiend");
        warlock.add("Hexblade");
        warlock.add("Undead");

        List<String> wizard = new ArrayList<>();
        wizard.add("Bladesinging");
        wizard.add("Graviturgy");
        wizard.add("Scribes");
        wizard.add("War Magic");

        var subclass = character.getSubclass();

        switch (character.getCharacterClass()) {
            case "Artificer":
                if (artificer.contains(subclass)) return true;
                break;
            case "Barbarian":
                if (barbarian.contains(subclass)) return true;
                break;
            case "Bard":
                if (bard.contains(subclass)) return true;
                break;
            case "Cleric":
                if (cleric.contains(subclass)) return true;
                break;
            case "Druid":
                if (druid.contains(subclass)) return true;
                break;
            case "Fighter":
                if (fighter.contains(subclass)) return true;
                break;
            case "Monk":
                if (monk.contains(subclass)) return true;
                break;
            case "Paladin":
                if (paladin.contains(subclass)) return true;
                break;
            case "Ranger":
                if (ranger.contains(subclass)) return true;
                break;
            case "Rogue":
                if (rogue.contains(subclass)) return true;
                break;
            case "Sorcerer":
                if (sorcerer.contains(subclass)) return true;
                break;
            case "Warlock":
                if (warlock.contains(subclass)) return true;
                break;
            case "Wizard":
                if (wizard.contains(subclass)) return true;
                break;
            default:
        }
        return false;
    }

    private boolean checkMulticlassSubclass (Character character) {
        List<String> artificer = new ArrayList<>();
        artificer.add("Alchemist");
        artificer.add("Armorer");
        artificer.add("Artillerist");
        artificer.add("Battle Smith");

        List<String> barbarian = new ArrayList<>();
        barbarian.add("Berserker");
        barbarian.add("Storm Herald");
        barbarian.add("Totem Warriror");
        barbarian.add("Wild Magic");

        List<String> bard = new ArrayList<>();
        bard.add("Lore");
        bard.add("Swords");
        bard.add("Valor");
        bard.add("Glamour");

        List<String> cleric = new ArrayList<>();
        cleric.add("Life");
        cleric.add("Twilight");
        cleric.add("Grave");
        cleric.add("Tempest");

        List<String> druid = new ArrayList<>();
        druid.add("Moon");
        druid.add("Dreams");
        druid.add("Spores");
        druid.add("Stars");

        List<String> fighter = new ArrayList<>();
        fighter.add("Battle Master");
        fighter.add("Echo Knight");
        fighter.add("Rune Knight");
        fighter.add("Samurai");

        List<String> monk = new ArrayList<>();
        monk.add("Astral Self");
        monk.add("Drunken Master");
        monk.add("Four Elements");
        monk.add("Open Hand");

        List<String> paladin = new ArrayList<>();
        paladin.add("Ancients");
        paladin.add("Conquest");
        paladin.add("Glory");
        paladin.add("Oathbreaker");

        List<String> ranger = new ArrayList<>();
        ranger.add("Beast Master");
        ranger.add("Gloom Stalker");
        ranger.add("Hunter");
        ranger.add("Swarmkeeper");

        List<String> rogue = new ArrayList<>();
        rogue.add("Arcane Trickster");
        rogue.add("Assassin");
        rogue.add("Mastermind");
        rogue.add("Phantom");

        List<String> sorcerer = new ArrayList<>();
        sorcerer.add("Draconic Bloodline");
        sorcerer.add("Divine Soul");
        sorcerer.add("Shadow Magic");
        sorcerer.add("Storm Sorcery");

        List<String> warlock = new ArrayList<>();
        warlock.add("Archfey");
        warlock.add("Fiend");
        warlock.add("Hexblade");
        warlock.add("Undead");

        List<String> wizard = new ArrayList<>();
        wizard.add("Bladesinging");
        wizard.add("Graviturgy");
        wizard.add("Scribes");
        wizard.add("War Magic");

        var subclass = character.getMulticlassSubclass();

        switch (character.getCharacterMulticlass()) {
            case "Artificer":
                if (artificer.contains(subclass)) return true;
                break;
            case "Barbarian":
                if (barbarian.contains(subclass)) return true;
                break;
            case "Bard":
                if (bard.contains(subclass)) return true;
                break;
            case "Cleric":
                if (cleric.contains(subclass)) return true;
                break;
            case "Druid":
                if (druid.contains(subclass)) return true;
                break;
            case "Fighter":
                if (fighter.contains(subclass)) return true;
                break;
            case "Monk":
                if (monk.contains(subclass)) return true;
                break;
            case "Paladin":
                if (paladin.contains(subclass)) return true;
                break;
            case "Ranger":
                if (ranger.contains(subclass)) return true;
                break;
            case "Rogue":
                if (rogue.contains(subclass)) return true;
                break;
            case "Sorcerer":
                if (sorcerer.contains(subclass)) return true;
                break;
            case "Warlock":
                if (warlock.contains(subclass)) return true;
                break;
            case "Wizard":
                if (wizard.contains(subclass)) return true;
                break;
            default:
        }
        return false;
    }
}

