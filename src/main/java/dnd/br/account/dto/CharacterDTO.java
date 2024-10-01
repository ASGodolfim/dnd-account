package dnd.br.account.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonPropertyOrder({"id","name","strength","constitution", "dexterity", "wisdom","intelligence","charisma","character_level","character_class","subclass","class_level","multiclass", "character_multiclass", "multiclass_subclass", "life", "armor_class", "gold", "armor", "weapon", "treasure"})
public class CharacterDTO {


    private long id;
    private String name;
    private Integer strength;
    private Integer constitution;
    private Integer dexterity;
    private Integer wisdom;
    private Integer intelligence;
    private Integer charisma;
    private Integer characterLevel;
    private String characterClass;
    private String subclass;
    private Integer classLevel;
    private Boolean multiclass;
    private String characterMulticlass;
    private String multiclassSubclass;
    private Integer life;
    private Integer armorClass;
    private Integer gold;
    private String armor;
    private List<String> weapon;
    private List<String> treasure;

    public CharacterDTO() {
    }

    public CharacterDTO(long id, String name, Integer strength, Integer constitution, Integer dexterity, Integer wisdom, Integer intelligence, Integer charisma, Integer characterLevel, String characterClass, String subclass, Integer classLevel, Boolean multiclass, String characterMulticlass, String multiclassSubclass, Integer life, Integer armorClass, Integer gold, String armor, List<String> weapon, List<String> treasure) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.characterLevel = characterLevel;
        this.characterClass = characterClass;
        this.subclass = subclass;
        this.classLevel = classLevel;
        this.multiclass = multiclass;
        this.characterMulticlass = characterMulticlass;
        this.multiclassSubclass = multiclassSubclass;
        this.life = life;
        this.armorClass = armorClass;
        this.gold = gold;
        this.armor = armor;
        this.weapon = weapon;
        this.treasure = treasure;
    }
}
