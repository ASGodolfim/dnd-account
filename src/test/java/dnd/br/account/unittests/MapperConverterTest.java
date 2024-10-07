package dnd.br.account.unittests;

import dnd.br.account.config.map.Mapper;
import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.unittests.mocks.MockCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperConverterTest {

    MockCharacter inputObject;

    @BeforeEach
    public void setUp(){
        inputObject = new MockCharacter();
    }

    @Test
    public void parseEntityToDTOTest(){
        CharacterDTO output = Mapper.parseChar(inputObject.mockEntity(), CharacterDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Test Username", output.getAccountUsername());
        assertEquals("Test username0", output.getName());
        assertEquals(Integer.valueOf(0), output.getStrength());
        assertEquals(Integer.valueOf(0), output.getConstitution());
        assertEquals(Integer.valueOf(0), output.getDexterity());
        assertEquals(Integer.valueOf(0), output.getIntelligence());
        assertEquals(Integer.valueOf(0), output.getCharisma());
        assertEquals(Integer.valueOf(0), output.getCharacterLevel());
        assertEquals("Test Class0", output.getCharacterClass());
        assertEquals("Test Subclass0", output.getSubclass());
        assertEquals(Integer.valueOf(0), output.getClassLevel());
        assertEquals(false, output.getMulticlass());
        assertEquals("Test Multiclass0", output.getCharacterMulticlass());
        assertEquals("Test multiclass subclass0", output.getMulticlassSubclass());
        assertEquals(Integer.valueOf(0), output.getMulticlassLevel());
        assertEquals(Integer.valueOf(0), output.getLife());
        assertEquals(Integer.valueOf(0), output.getArmorClass());
        assertEquals(Integer.valueOf(0), output.getGold());
        assertEquals("Test Armor0", output.getArmor());
        assertEquals("Test Weapon0", output.getWeapon());
        assertEquals("Test Treasure0", output.getTreasure());
    }

    @Test
    public void parseEntityListToDTOListTest(){
        List<CharacterDTO> outputList = Mapper.parseListChar(inputObject.mockEntityList(), CharacterDTO.class);
        CharacterDTO outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Test Username", outputZero.getAccountUsername());
        assertEquals("Test username0", outputZero.getName());
        assertEquals(Integer.valueOf(0), outputZero.getStrength());
        assertEquals(Integer.valueOf(0), outputZero.getConstitution());
        assertEquals(Integer.valueOf(0), outputZero.getDexterity());
        assertEquals(Integer.valueOf(0), outputZero.getIntelligence());
        assertEquals(Integer.valueOf(0), outputZero.getCharisma());
        assertEquals(Integer.valueOf(0), outputZero.getCharacterLevel());
        assertEquals("Test Class0", outputZero.getCharacterClass());
        assertEquals("Test Subclass0", outputZero.getSubclass());
        assertEquals(Integer.valueOf(0), outputZero.getClassLevel());
        assertEquals(false, outputZero.getMulticlass());
        assertEquals("Test Multiclass0", outputZero.getCharacterMulticlass());
        assertEquals("Test multiclass subclass0", outputZero.getMulticlassSubclass());
        assertEquals(Integer.valueOf(0), outputZero.getMulticlassLevel());
        assertEquals(Integer.valueOf(0), outputZero.getLife());
        assertEquals(Integer.valueOf(0), outputZero.getArmorClass());
        assertEquals(Integer.valueOf(0), outputZero.getGold());
        assertEquals("Test Armor0", outputZero.getArmor());
        assertEquals("Test Weapon0", outputZero.getWeapon());
        assertEquals("Test Treasure0", outputZero.getTreasure());

        CharacterDTO outputFive = outputList.get(5);
        assertEquals(Long.valueOf(5L), outputFive.getId());
        assertEquals("Test Username", outputFive.getAccountUsername());
        assertEquals("Test username5", outputFive.getName());
        assertEquals(Integer.valueOf(5), outputFive.getStrength());
        assertEquals(Integer.valueOf(5), outputFive.getConstitution());
        assertEquals(Integer.valueOf(5), outputFive.getDexterity());
        assertEquals(Integer.valueOf(5), outputFive.getIntelligence());
        assertEquals(Integer.valueOf(5), outputFive.getCharisma());
        assertEquals(Integer.valueOf(5), outputFive.getCharacterLevel());
        assertEquals("Test Class5", outputFive.getCharacterClass());
        assertEquals("Test Subclass5", outputFive.getSubclass());
        assertEquals(Integer.valueOf(5), outputFive.getClassLevel());
        assertEquals(false, outputFive.getMulticlass());
        assertEquals("Test Multiclass5", outputFive.getCharacterMulticlass());
        assertEquals("Test multiclass subclass5", outputFive.getMulticlassSubclass());
        assertEquals(Integer.valueOf(5), outputFive.getMulticlassLevel());
        assertEquals(Integer.valueOf(5), outputFive.getLife());
        assertEquals(Integer.valueOf(5), outputFive.getArmorClass());
        assertEquals(Integer.valueOf(5), outputFive.getGold());
        assertEquals("Test Armor5", outputFive.getArmor());
        assertEquals("Test Weapon5", outputFive.getWeapon());
        assertEquals("Test Treasure5", outputFive.getTreasure());

        CharacterDTO outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Test Username", outputSeven.getAccountUsername());
        assertEquals("Test username7", outputSeven.getName());
        assertEquals(Integer.valueOf(7), outputSeven.getStrength());
        assertEquals(Integer.valueOf(7), outputSeven.getConstitution());
        assertEquals(Integer.valueOf(7), outputSeven.getDexterity());
        assertEquals(Integer.valueOf(7), outputSeven.getIntelligence());
        assertEquals(Integer.valueOf(7), outputSeven.getCharisma());
        assertEquals(Integer.valueOf(7), outputSeven.getCharacterLevel());
        assertEquals("Test Class7", outputSeven.getCharacterClass());
        assertEquals("Test Subclass7", outputSeven.getSubclass());
        assertEquals(Integer.valueOf(7), outputSeven.getClassLevel());
        assertEquals(false, outputSeven.getMulticlass());
        assertEquals("Test Multiclass7", outputSeven.getCharacterMulticlass());
        assertEquals("Test multiclass subclass7", outputSeven.getMulticlassSubclass());
        assertEquals(Integer.valueOf(7), outputSeven.getMulticlassLevel());
        assertEquals(Integer.valueOf(7), outputSeven.getLife());
        assertEquals(Integer.valueOf(7), outputSeven.getArmorClass());
        assertEquals(Integer.valueOf(7), outputSeven.getGold());
        assertEquals("Test Armor7", outputSeven.getArmor());
        assertEquals("Test Weapon7", outputSeven.getWeapon());
        assertEquals("Test Treasure7", outputSeven.getTreasure());
    }
}
