package dnd.br.account.unittests.mocks;

import dnd.br.account.dto.UserDTO;
import dnd.br.account.entity.User;

import java.util.ArrayList;
import java.util.List;

public class MockUser {

    public User mockEntity(){
        return mockEntity(0);
    }

    public UserDTO mockDTO(){
        return mockDTO(0);
    }

    public List<User> mockEntityList(){
        List<User> users = new ArrayList<>();
        for (int i=0 ; i < 5; i++){
            users.add(mockEntity(i));
        }
        return users;
    }

    public User mockEntity(Integer number){
        User user = new User(
                number.longValue(),
                "Test username" + number,
                "Test password" + number,
                "Test name" + number,
                "Test email" + number,
                number,
                true,
                true,
                true,
                true);
        return user;
    }

    public UserDTO mockDTO(Integer number) {
        UserDTO user = new UserDTO();
        user.setId(number.longValue());
        user.setUser_name("Test username" + number);
        user.setPassword("Test password" + number);
        user.setName("Test name" + number);
        user.setEmail("Test email" + number);
        user.setAge(number);
        return user;
    }
}
