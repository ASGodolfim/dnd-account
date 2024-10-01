package dnd.br.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "character")
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
    @Column(name = "character_level", nullable = false)
    private Integer characterLevel;
    @Column(name = "character_class", nullable = false)
    private String characterClass;
    @Column(nullable = false)
    private String subclass;
    @Column(name = "class_level", nullable = false)
    private Integer classLevel;
    @Column(nullable = false)
    private Boolean multiclass;
    @Column(name = "character_multiclass")
    private String characterMulticlass;
    @Column(name = "multiclass_subclass")
    private String multiclassSubclass;
    @Column(name = "multiclass_level")
    private Integer multiclassLevel;
    @Column(nullable = false)
    private Integer life;
    @Column(name = "armor_class", nullable = false)
    private Integer armorClass;
    @Column
    private Integer gold;
    @Column
    private String armor;
    @Column
    private List<String> weapon;
    @Column
    private List<String> treasure;

    public Character(){}

    public Character(Long id,String accountUsername,  String name, Integer strength, Integer constitution, Integer dexterity, Integer wisdom, Integer intelligence, Integer charisma, Integer characterLevel, String characterClass, String subclass, Integer classLevel, Boolean multiclass, String characterMulticlass, String multiclassSubclass, Integer multiclassLevel, Integer life, Integer armorClass, Integer gold, String armor, List<String> weapon, List<String> treasure) {
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

    public Character(long id, String accountUsername, String name, Integer strength, Integer constitution, Integer dexterity, Integer wisdom, Integer intelligence, Integer charisma, Integer characterLevel, String characterClass, String subclass, Boolean multiclass, String characterMulticlass, String multiclassSubclass, Integer multiclassLevel, Integer life, Integer armorClass, Integer gold, String armor, List<String> weapon, List<String> treasure) {
    }
}
