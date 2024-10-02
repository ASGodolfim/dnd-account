package dnd.br.account.repository;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import dnd.br.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    @Query("SELECT c FROM Character c WHERE c.accountUsername =:accountUsername AND c.name =:name")
    Character findByUsernameAndName(@Param("accountUsername") String username, @Param("name") String name);
}