package dnd.br.account.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "characters")
@JsonPropertyOrder({"id","account_username","name","strength","constitution", "dexterity", "wisdom","intelligence","charisma","character_level","character_class","subclass","class_level","multiclass", "character_multiclass", "multiclass_subclass", "multiclass_level", "life", "armor_class", "gold", "armor", "weapon", "treasure"})
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_username", nullable = false)
    private String accountUsername;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer strength;
    @Column(nullable = false)
    private Integer constitution;
    @Column(nullable = false)
    private Integer dexterity;
    @Column(nullable = false)
    private Integer wisdom;
    @Column(nullable = false)
    private Integer intelligence;
    @Column(nullable = false)
    private Integer charisma;
    @Column(name = "character_level")
    private Integer characterLevel = 0;
    @Column(name = "character_class", nullable = false)
    private String characterClass;
    @Column(nullable = true)
    private String subclass;
    @Column(name = "class_level", nullable = false)
    private Integer classLevel;
    @Column(nullable = false)
    private Boolean multiclass;
    @Column(name = "character_multiclass", nullable = true)
    private String characterMulticlass;
    @Column(name = "multiclass_subclass", nullable = true)
    private String multiclassSubclass;
    @Column(name = "multiclass_level", nullable = true)
    private Integer multiclassLevel;
    @Column
    private Integer life;
    @Column(name = "armor_class", nullable = false)
    private Integer armorClass;
    @Column(nullable = true)
    private Integer gold = 0;
    @Column(nullable = true)
    private String armor;
    @Column(nullable = true)
    private String weapon;
    @Column(nullable = true)
    private String treasure;

    public Character(){}

    public Character(Long id,String accountUsername,  String name, Integer strength, Integer constitution, Integer dexterity, Integer wisdom, Integer intelligence, Integer charisma, Integer characterLevel, String characterClass, String subclass, Integer classLevel, Boolean multiclass, String characterMulticlass, String multiclassSubclass, Integer multiclassLevel, Integer life, Integer armorClass, Integer gold, String armor, String weapon, String treasure) {
        this.id = id;
        this.accountUsername = accountUsername;
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
        this.multiclassLevel = multiclassLevel;
        this.life = life;
        this.armorClass = armorClass;
        this.gold = gold;
        this.armor = armor;
        this.weapon = weapon;
        this.treasure = treasure;
    }

    public Character(long id, String accountUsername, String name, Integer strength, Integer constitution, Integer dexterity, Integer wisdom, Integer intelligence, Integer charisma, Integer characterLevel, String characterClass, String subclass, Boolean multiclass, String characterMulticlass, String multiclassSubclass, Integer multiclassLevel, Integer life, Integer armorClass, Integer gold, String armor, String weapon, String treasure) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) && Objects.equals(accountUsername, character.accountUsername) && Objects.equals(name, character.name) && Objects.equals(strength, character.strength) && Objects.equals(constitution, character.constitution) && Objects.equals(dexterity, character.dexterity) && Objects.equals(wisdom, character.wisdom) && Objects.equals(intelligence, character.intelligence) && Objects.equals(charisma, character.charisma) && Objects.equals(characterLevel, character.characterLevel) && Objects.equals(characterClass, character.characterClass) && Objects.equals(subclass, character.subclass) && Objects.equals(classLevel, character.classLevel) && Objects.equals(multiclass, character.multiclass) && Objects.equals(characterMulticlass, character.characterMulticlass) && Objects.equals(multiclassSubclass, character.multiclassSubclass) && Objects.equals(multiclassLevel, character.multiclassLevel) && Objects.equals(life, character.life) && Objects.equals(armorClass, character.armorClass) && Objects.equals(gold, character.gold) && Objects.equals(armor, character.armor) && Objects.equals(weapon, character.weapon) && Objects.equals(treasure, character.treasure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountUsername, name, strength, constitution, dexterity, wisdom, intelligence, charisma, characterLevel, characterClass, subclass, classLevel, multiclass, characterMulticlass, multiclassSubclass, multiclassLevel, life, armorClass, gold, armor, weapon, treasure);
    }
}
