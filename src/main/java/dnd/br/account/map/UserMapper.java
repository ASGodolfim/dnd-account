package dnd.br.account.map;

import dnd.br.account.dto.UserDTO;
import dnd.br.account.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {


    public UserDTO convertEntityToDTO (User user) {
        UserDTO dto = new UserDTO();
        return dto;
    }
}
