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
    @Column(nullable = false)
    private Integer characterLevel;
    @Column(nullable = false)
    private String characterClass;
    @Column(nullable = false)
    private String subClass;
    @Column(nullable = false)
    private Integer classLevel;
    @Column(nullable = false)
    private Boolean multiClass;
    private String characterMultiClass;
    private String multiClassSubClass;
    @Column(nullable = false)
    private Integer life;
    @Column(nullable = false)
    private Integer armorClass;
    private Integer gold;
    private String armor;
    private List<String> weapon;
    private List<String> treasure;

    public Character(){}

    public Character(Long id, String name, Integer strength, Integer constitution, Integer dexterity, Integer wisdom, Integer intelligence, Integer charisma, Integer characterLevel, String characterClass, String subClass, Integer classLevel, Boolean multiClass, String characterMultiClass, String multiClassSubClass, Integer life, Integer armorClass, Integer gold, String armor, List<String> weapon, List<String> treasure) {
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
        this.subClass = subClass;
        this.classLevel = classLevel;
        this.multiClass = multiClass;
        this.characterMultiClass = characterMultiClass;
        this.multiClassSubClass = multiClassSubClass;
        this.life = life;
        this.armorClass = armorClass;
        this.gold = gold;
        this.armor = armor;
        this.weapon = weapon;
        this.treasure = treasure;
    }
}
