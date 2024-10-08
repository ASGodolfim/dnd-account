package dnd.br.account.entity.junit.mockito.services;

import dnd.br.account.config.repository.CharacterRepository;
import dnd.br.account.config.services.CharacterServices;
import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import dnd.br.account.exeptions.RequiredObjectIsNullException;
import dnd.br.account.unittests.mocks.MockCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class CharacterServicesTest {

    MockCharacter input;

    @InjectMocks
    private CharacterServices services;

    @Mock
    CharacterRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockCharacter();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() throws Exception {
        Character persisted = input.mockEntity(1);

        CharacterDTO dto = input.mockDTO(1);
        dto.setId(1L);

        when(repository.save(any(Character.class))).thenReturn(persisted);

        CharacterDTO result = services.create(dto);

        assertNotNull(result);
        assertEquals("Test Username", result.getAccountUsername());
        assertEquals("Test name1", result.getName());
        assertEquals(Integer.valueOf(1), result.getStrength());
        assertEquals(Integer.valueOf(1), result.getConstitution());
        assertEquals(Integer.valueOf(1), result.getDexterity());
        assertEquals(Integer.valueOf(1), result.getIntelligence());
        assertEquals(Integer.valueOf(1), result.getCharisma());
        assertEquals(Integer.valueOf(1), result.getCharacterLevel());
        assertEquals("Test Class1", result.getCharacterClass());
        assertEquals("Test Subclass1", result.getSubclass());
        assertEquals(Integer.valueOf(1), result.getClassLevel());
        assertEquals(false, result.getMulticlass());
        assertEquals("Test multiclass1", result.getCharacterMulticlass());
        assertEquals("Test multiclass subclass1", result.getMulticlassSubclass());
        assertEquals(Integer.valueOf(1), result.getMulticlassLevel());
        assertEquals(Integer.valueOf(1), result.getLife());
        assertEquals(Integer.valueOf(1), result.getArmorClass());
        assertEquals(Integer.valueOf(1), result.getGold());
        assertEquals("Test Armor1", result.getArmor());
        assertEquals("Test Weapon1", result.getWeapon());
        assertEquals("Test Treasure1", result.getTreasure());
    }

    @Test
    void createWithNullCharacter() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            services.create(null);
        });

        String expectedMessage = "Object Is Null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void update() throws Exception {
        var entity = input.mockEntity(1);

        CharacterDTO dto = input.mockDTO(1);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(any(Character.class))).thenReturn(entity);

        CharacterDTO result = services.update(dto);

        assertNotNull(result);
        assertEquals("Test Username", result.getAccountUsername());
        assertEquals("Test name1", result.getName());
        assertEquals(Integer.valueOf(1), result.getStrength());
        assertEquals(Integer.valueOf(1), result.getConstitution());
        assertEquals(Integer.valueOf(1), result.getDexterity());
        assertEquals(Integer.valueOf(1), result.getIntelligence());
        assertEquals(Integer.valueOf(1), result.getCharisma());
        assertEquals(Integer.valueOf(1), result.getCharacterLevel());
        assertEquals("Test Class1", result.getCharacterClass());
        assertEquals("Test Subclass1", result.getSubclass());
        assertEquals(Integer.valueOf(1), result.getClassLevel());
        assertEquals(false, result.getMulticlass());
        assertNull(result.getCharacterMulticlass());
        assertNull(result.getMulticlassSubclass());
        assertEquals(Integer.valueOf(0), result.getMulticlassLevel());
        assertEquals(Integer.valueOf(7), result.getLife());
        assertEquals(Integer.valueOf(1), result.getArmorClass());
        assertEquals(Integer.valueOf(1), result.getGold());
        assertEquals("Test Armor1", result.getArmor());
        assertEquals("Test Weapon1", result.getWeapon());
        assertEquals("Test Treasure1", result.getTreasure());
    }

    @Test
    void updateWithNullCharacter(){
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            services.update(null);
        });

        String expectedMessage = "Object Is Null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete(){
        Character entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        services.delete(1L);
    }

    @Test
    void findById() throws Exception{
        Character entity = input.mockEntity(1);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = services.findById(1L);
        assertNotNull(result);
        assertEquals("Test Username", result.getAccountUsername());
        assertEquals("Test name1", result.getName());
        assertEquals(Integer.valueOf(1), result.getStrength());
        assertEquals(Integer.valueOf(1), result.getConstitution());
        assertEquals(Integer.valueOf(1), result.getDexterity());
        assertEquals(Integer.valueOf(1), result.getIntelligence());
        assertEquals(Integer.valueOf(1), result.getCharisma());
        assertEquals(Integer.valueOf(1), result.getCharacterLevel());
        assertEquals("Test Class1", result.getCharacterClass());
        assertEquals("Test Subclass1", result.getSubclass());
        assertEquals(Integer.valueOf(1), result.getClassLevel());
        assertEquals(false, result.getMulticlass());
        assertEquals("Test multiclass1", result.getCharacterMulticlass());
        assertEquals("Test multiclass subclass1", result.getMulticlassSubclass());
        assertEquals(Integer.valueOf(1), result.getMulticlassLevel());
        assertEquals(Integer.valueOf(1), result.getLife());
        assertEquals(Integer.valueOf(1), result.getArmorClass());
        assertEquals(Integer.valueOf(1), result.getGold());
        assertEquals("Test Armor1", result.getArmor());
        assertEquals("Test Weapon1", result.getWeapon());
        assertEquals("Test Treasure1", result.getTreasure());
    }

    @Test
    void findAll(Pageable pageable){
        List<Character> entityList = input.mockEntityList();

        when(repository.findAll()).thenReturn(entityList);

        var characters = services.findAll(pageable);



        assertNotNull(characters);
        assertEquals(11, characters.size());

        var characterOne = characters.get(1);
        assertNotNull(characterOne);
        assertEquals("Test Username", characterOne.getAccountUsername());
        assertEquals("Test name1", characterOne.getName());
        assertEquals(Integer.valueOf(1), characterOne.getStrength());
        assertEquals(Integer.valueOf(1), characterOne.getConstitution());
        assertEquals(Integer.valueOf(1), characterOne.getDexterity());
        assertEquals(Integer.valueOf(1), characterOne.getIntelligence());
        assertEquals(Integer.valueOf(1), characterOne.getCharisma());
        assertEquals(Integer.valueOf(1), characterOne.getCharacterLevel());
        assertEquals("Test Class1", characterOne.getCharacterClass());
        assertEquals("Test Subclass1", characterOne.getSubclass());
        assertEquals(Integer.valueOf(1), characterOne.getClassLevel());
        assertEquals(false, characterOne.getMulticlass());
        assertEquals("Test multiclass1", characterOne.getCharacterMulticlass());
        assertEquals("Test multiclass subclass1", characterOne.getMulticlassSubclass());
        assertEquals(Integer.valueOf(1), characterOne.getMulticlassLevel());
        assertEquals(Integer.valueOf(1), characterOne.getLife());
        assertEquals(Integer.valueOf(1), characterOne.getArmorClass());
        assertEquals(Integer.valueOf(1), characterOne.getGold());
        assertEquals("Test Armor1", characterOne.getArmor());
        assertEquals("Test Weapon1", characterOne.getWeapon());
        assertEquals("Test Treasure1", characterOne.getTreasure());

        var characterFour = characters.get(4);
        assertNotNull(characterFour);
        assertEquals("Test Username", characterFour.getAccountUsername());
        assertEquals("Test name4", characterFour.getName());
        assertEquals(Integer.valueOf(4), characterFour.getStrength());
        assertEquals(Integer.valueOf(4), characterFour.getConstitution());
        assertEquals(Integer.valueOf(4), characterFour.getDexterity());
        assertEquals(Integer.valueOf(4), characterFour.getIntelligence());
        assertEquals(Integer.valueOf(4), characterFour.getCharisma());
        assertEquals(Integer.valueOf(4), characterFour.getCharacterLevel());
        assertEquals("Test Class4", characterFour.getCharacterClass());
        assertEquals("Test Subclass4", characterFour.getSubclass());
        assertEquals(Integer.valueOf(4), characterFour.getClassLevel());
        assertEquals(false, characterFour.getMulticlass());
        assertEquals("Test multiclass4", characterFour.getCharacterMulticlass());
        assertEquals("Test multiclass subclass4", characterFour.getMulticlassSubclass());
        assertEquals(Integer.valueOf(4), characterFour.getMulticlassLevel());
        assertEquals(Integer.valueOf(4), characterFour.getLife());
        assertEquals(Integer.valueOf(4), characterFour.getArmorClass());
        assertEquals(Integer.valueOf(4), characterFour.getGold());
        assertEquals("Test Armor4", characterFour.getArmor());
        assertEquals("Test Weapon4", characterFour.getWeapon());
        assertEquals("Test Treasure4", characterFour.getTreasure());

        var characterEight = characters.get(8);
        assertNotNull(characterEight);
        assertEquals("Test Username", characterEight.getAccountUsername());
        assertEquals("Test name8", characterEight.getName());
        assertEquals(Integer.valueOf(8), characterEight.getStrength());
        assertEquals(Integer.valueOf(8), characterEight.getConstitution());
        assertEquals(Integer.valueOf(8), characterEight.getDexterity());
        assertEquals(Integer.valueOf(8), characterEight.getIntelligence());
        assertEquals(Integer.valueOf(8), characterEight.getCharisma());
        assertEquals(Integer.valueOf(8), characterEight.getCharacterLevel());
        assertEquals("Test Class8", characterEight.getCharacterClass());
        assertEquals("Test Subclass8", characterEight.getSubclass());
        assertEquals(Integer.valueOf(8), characterEight.getClassLevel());
        assertEquals(false, characterEight.getMulticlass());
        assertEquals("Test multiclass8", characterEight.getCharacterMulticlass());
        assertEquals("Test multiclass subclass8", characterEight.getMulticlassSubclass());
        assertEquals(Integer.valueOf(8), characterEight.getMulticlassLevel());
        assertEquals(Integer.valueOf(8), characterEight.getLife());
        assertEquals(Integer.valueOf(8), characterEight.getArmorClass());
        assertEquals(Integer.valueOf(8), characterEight.getGold());
        assertEquals("Test Armor8", characterEight.getArmor());
        assertEquals("Test Weapon8", characterEight.getWeapon());
        assertEquals("Test Treasure8", characterEight.getTreasure());
    }

    @Test
    public void findByUsernameAndName() throws Exception {
        Character entity = input.mockEntity(1);

        when(repository.findByUsernameAndName("Test Username", "Test name1")).thenReturn(entity);

        var result = services.FindByUsernameAndName("Test Username", "Test name1");

        assertNotNull(result);
        assertEquals("Test Username", result.getAccountUsername());
        assertEquals("Test name1", result.getName());
        assertEquals(Integer.valueOf(1), result.getStrength());
        assertEquals(Integer.valueOf(1), result.getConstitution());
        assertEquals(Integer.valueOf(1), result.getDexterity());
        assertEquals(Integer.valueOf(1), result.getIntelligence());
        assertEquals(Integer.valueOf(1), result.getCharisma());
        assertEquals(Integer.valueOf(1), result.getCharacterLevel());
        assertEquals("Test Class1", result.getCharacterClass());
        assertEquals("Test Subclass1", result.getSubclass());
        assertEquals(Integer.valueOf(1), result.getClassLevel());
        assertEquals(false, result.getMulticlass());
        assertEquals("Test multiclass1", result.getCharacterMulticlass());
        assertEquals("Test multiclass subclass1", result.getMulticlassSubclass());
        assertEquals(Integer.valueOf(1), result.getMulticlassLevel());
        assertEquals(Integer.valueOf(1), result.getLife());
        assertEquals(Integer.valueOf(1), result.getArmorClass());
        assertEquals(Integer.valueOf(1), result.getGold());
        assertEquals("Test Armor1", result.getArmor());
        assertEquals("Test Weapon1", result.getWeapon());
        assertEquals("Test Treasure1", result.getTreasure());
    }

    @Test
    public void findByUsername(){
        List<Character> entityList = input.mockEntityList();

        when(repository.findAll()).thenReturn(entityList);

        var characters = services.findByAccountUsername("Test Username", pageable);

        assertNotNull(characters);
        assertEquals(11, characters.size());

        var characterOne = characters.get(1);
        assertNotNull(characterOne);
        assertEquals("Test Username", characterOne.getAccountUsername());
        assertEquals("Test name1", characterOne.getName());
        assertEquals(Integer.valueOf(1), characterOne.getStrength());
        assertEquals(Integer.valueOf(1), characterOne.getConstitution());
        assertEquals(Integer.valueOf(1), characterOne.getDexterity());
        assertEquals(Integer.valueOf(1), characterOne.getIntelligence());
        assertEquals(Integer.valueOf(1), characterOne.getCharisma());
        assertEquals(Integer.valueOf(1), characterOne.getCharacterLevel());
        assertEquals("Test Class1", characterOne.getCharacterClass());
        assertEquals("Test Subclass1", characterOne.getSubclass());
        assertEquals(Integer.valueOf(1), characterOne.getClassLevel());
        assertEquals(false, characterOne.getMulticlass());
        assertEquals("Test multiclass1", characterOne.getCharacterMulticlass());
        assertEquals("Test multiclass subclass1", characterOne.getMulticlassSubclass());
        assertEquals(Integer.valueOf(1), characterOne.getMulticlassLevel());
        assertEquals(Integer.valueOf(1), characterOne.getLife());
        assertEquals(Integer.valueOf(1), characterOne.getArmorClass());
        assertEquals(Integer.valueOf(1), characterOne.getGold());
        assertEquals("Test Armor1", characterOne.getArmor());
        assertEquals("Test Weapon1", characterOne.getWeapon());
        assertEquals("Test Treasure1", characterOne.getTreasure());

        var characterFour = characters.get(4);
        assertNotNull(characterFour);
        assertEquals("Test Username", characterFour.getAccountUsername());
        assertEquals("Test name4", characterFour.getName());
        assertEquals(Integer.valueOf(4), characterFour.getStrength());
        assertEquals(Integer.valueOf(4), characterFour.getConstitution());
        assertEquals(Integer.valueOf(4), characterFour.getDexterity());
        assertEquals(Integer.valueOf(4), characterFour.getIntelligence());
        assertEquals(Integer.valueOf(4), characterFour.getCharisma());
        assertEquals(Integer.valueOf(4), characterFour.getCharacterLevel());
        assertEquals("Test Class4", characterFour.getCharacterClass());
        assertEquals("Test Subclass4", characterFour.getSubclass());
        assertEquals(Integer.valueOf(4), characterFour.getClassLevel());
        assertEquals(false, characterFour.getMulticlass());
        assertEquals("Test multiclass4", characterFour.getCharacterMulticlass());
        assertEquals("Test multiclass subclass4", characterFour.getMulticlassSubclass());
        assertEquals(Integer.valueOf(4), characterFour.getMulticlassLevel());
        assertEquals(Integer.valueOf(4), characterFour.getLife());
        assertEquals(Integer.valueOf(4), characterFour.getArmorClass());
        assertEquals(Integer.valueOf(4), characterFour.getGold());
        assertEquals("Test Armor4", characterFour.getArmor());
        assertEquals("Test Weapon4", characterFour.getWeapon());
        assertEquals("Test Treasure4", characterFour.getTreasure());

        var characterEight = characters.get(8);
        assertNotNull(characterEight);
        assertEquals("Test Username", characterEight.getAccountUsername());
        assertEquals("Test name8", characterEight.getName());
        assertEquals(Integer.valueOf(8), characterEight.getStrength());
        assertEquals(Integer.valueOf(8), characterEight.getConstitution());
        assertEquals(Integer.valueOf(8), characterEight.getDexterity());
        assertEquals(Integer.valueOf(8), characterEight.getIntelligence());
        assertEquals(Integer.valueOf(8), characterEight.getCharisma());
        assertEquals(Integer.valueOf(8), characterEight.getCharacterLevel());
        assertEquals("Test Class8", characterEight.getCharacterClass());
        assertEquals("Test Subclass8", characterEight.getSubclass());
        assertEquals(Integer.valueOf(8), characterEight.getClassLevel());
        assertEquals(false, characterEight.getMulticlass());
        assertEquals("Test multiclass8", characterEight.getCharacterMulticlass());
        assertEquals("Test multiclass subclass8", characterEight.getMulticlassSubclass());
        assertEquals(Integer.valueOf(8), characterEight.getMulticlassLevel());
        assertEquals(Integer.valueOf(8), characterEight.getLife());
        assertEquals(Integer.valueOf(8), characterEight.getArmorClass());
        assertEquals(Integer.valueOf(8), characterEight.getGold());
        assertEquals("Test Armor8", characterEight.getArmor());
        assertEquals("Test Weapon8", characterEight.getWeapon());
        assertEquals("Test Treasure8", characterEight.getTreasure());
    }
}
