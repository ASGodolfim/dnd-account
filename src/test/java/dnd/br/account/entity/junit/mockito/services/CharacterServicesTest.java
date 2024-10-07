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
}
