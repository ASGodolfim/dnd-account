package dnd.br.account.unittests.mocks;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import java.util.ArrayList;
import java.util.List;

public class MockCharacter {

    public Character mockEntity() {
        return mockEntity(0);
    }

    public CharacterDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Character> mockEntityList(){
        List<Character> characters = new ArrayList<>();
        for (int i=0;i<=10;i++){
            characters.add(mockEntity(i));
        }
        return characters;
    }

    public Character mockEntity(Integer number){
        Character character = new Character();
                character.setId(number.longValue());
                character.setAccountUsername("Test Username");
                character.setName("Test name" + number);
                character.setStrength(number);
                character.setConstitution(number);
                character.setDexterity(number);
                character.setWisdom(number);
                character.setIntelligence(number);
                character.setCharisma(number);
                character.setCharacterLevel(number);
                character.setCharacterClass("Test Class" + number);
                character.setSubclass("Test Subclass" + number);
                character.setClassLevel(number);
                character.setMulticlass(false);
                character.setCharacterMulticlass("Test multiclass" + number);
                character.setMulticlassSubclass("Test multiclass subclass" + number);
                character.setMulticlassLevel(number);
                character.setLife(number);
                character.setArmorClass(number);
                character.setGold(number);
                character.setArmor("Test Armor" + number);
                character.setWeapon("Test Weapon" + number);
                character.setTreasure("Test Treasure" + number);
        return character;
    }

    public CharacterDTO mockDTO(Integer number) {
        CharacterDTO character = new CharacterDTO();
        character.setId(number.longValue());
        character.setAccountUsername("Test Username");
        character.setName("Test name" + number);
        character.setStrength(number);
        character.setConstitution(number);
        character.setDexterity(number);
        character.setWisdom(number);
        character.setIntelligence(number);
        character.setCharisma(number);
        character.setCharacterLevel(number);
        character.setCharacterClass("Test Class" + number);
        character.setSubclass("Test Subclass" + number);
        character.setClassLevel(number);
        character.setMulticlass(false);
        character.setCharacterMulticlass("Test multiclass" + number);
        character.setMulticlassSubclass("Test multiclass subclass" + number);
        character.setMulticlassLevel(number);
        character.setLife(number);
        character.setArmorClass(number);
        character.setGold(number);
        character.setArmor("Test Armor" + number);
        character.setWeapon("Test Weapon" + number);
        character.setTreasure("Test Treasure" + number);
        return character;
    }
}