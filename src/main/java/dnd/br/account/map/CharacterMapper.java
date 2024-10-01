package dnd.br.account.map;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import org.springframework.stereotype.Service;

@Service
public class CharacterMapper {

    public CharacterDTO convertEntityToDTO (Character character){
        CharacterDTO dto = new CharacterDTO(
                character.getId(),
                character.getAccountUsername(),
                character.getName(),
                character.getStrength(),
                character.getConstitution(),
                character.getDexterity(),
                character.getWisdom(),
                character.getIntelligence(),
                character.getCharisma(),
                character.getCharacterLevel(),
                character.getCharacterClass(),
                character.getSubclass(),
                character.getMulticlass(),
                character.getCharacterMulticlass(),
                character.getMulticlassSubclass(),
                character.getMulticlassLevel(),
                character.getLife(),
                character.getArmorClass(),
                character.getGold(),
                character.getArmor(),
                character.getWeapon(),
                character.getTreasure());
        return dto;
    }

    public Character convertDTOToEntity (CharacterDTO character){
        Character entity = new Character(
                character.getId(),
                character.getAccountUsername(),
                character.getName(),
                character.getStrength(),
                character.getConstitution(),
                character.getDexterity(),
                character.getWisdom(),
                character.getIntelligence(),
                character.getCharisma(),
                character.getCharacterLevel(),
                character.getCharacterClass(),
                character.getSubclass(),
                character.getMulticlass(),
                character.getCharacterMulticlass(),
                character.getMulticlassSubclass(),
                character.getMulticlassLevel(),
                character.getLife(),
                character.getArmorClass(),
                character.getGold(),
                character.getArmor(),
                character.getWeapon(),
                character.getTreasure());
        return entity;
    }
}
