package dnd.br.account.unittests.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import dnd.br.account.dto.CharacterDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


@Getter
@Setter
public class CharacterEmbeddedDTO {

    @JsonProperty("characterDTOList")
    private List<CharacterDTO> characters;

    public CharacterEmbeddedDTO() {
    }

    public CharacterEmbeddedDTO(List<CharacterDTO> characters) {
        this.characters = characters;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterEmbeddedDTO that = (CharacterEmbeddedDTO) o;
        return Objects.equals(characters, that.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(characters);
    }
}
