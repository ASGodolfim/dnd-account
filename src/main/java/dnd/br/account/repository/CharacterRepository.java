package dnd.br.account.repository;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findByUserame(String username);
    CharacterDTO findByName(String name);
}
