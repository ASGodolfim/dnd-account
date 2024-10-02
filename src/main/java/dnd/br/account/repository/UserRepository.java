package dnd.br.account.repository;

import dnd.br.account.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository {

    @Query("SELECT u FROM User u WHERE u.userName =:user_name")
    User findByUsername(@Param("user_name") String username);
}
