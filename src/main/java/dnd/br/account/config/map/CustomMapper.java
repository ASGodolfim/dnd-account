package dnd.br.account.config.map;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.dto.UserDTO;
import dnd.br.account.entity.Character;
import dnd.br.account.entity.User;
import org.springframework.stereotype.Service;

@Service
public class CustomMapper {

    public CharacterDTO convertEntityToDTO (Character character){
        return new CharacterDTO(
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
    }

    public Character convertDTOToEntity (CharacterDTO character){
        return new Character(
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
    }

    public UserDTO convertEntityToDTO (User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getAge());
    }

    public User ConvertDTOToEntity (UserDTO user){
        return new User(
                user.getId(),
                user.getUser_name(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getAge(),
                true,
                true,
                true,
                true);
    }
}
