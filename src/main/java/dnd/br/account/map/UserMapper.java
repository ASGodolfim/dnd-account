package dnd.br.account.map;

import dnd.br.account.dto.UserDTO;
import dnd.br.account.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {


    public UserDTO convertEntityToDTO (User user) {
        UserDTO dto = new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getAge());
        return dto;
    }

    public User ConvertDTOToEntity (UserDTO user){
        User entity = new User(
                user.getId(),
                user.getUser_name(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getAge(),
                true,
                true,
                true,
                true);
    return entity;
    }
}
