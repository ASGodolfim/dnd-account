package dnd.br.account.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

@Getter
@Setter
public class UserDTO extends RepresentationModel<UserDTO> {

    private Long id;
    private String user_name;
    private String password;
    private String name;
    private String email;
    private Integer age;

    public UserDTO(Long id, String user_name, String password, String name, Integer age) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public UserDTO() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(user_name, userDTO.user_name) && Objects.equals(password, userDTO.password) && Objects.equals(name, userDTO.name) && Objects.equals(email, userDTO.email) && Objects.equals(age, userDTO.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_name, password, name, email, age);
    }
}
