package dnd.br.account.unittests.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class WrapperCharacterDTO {

    @JsonProperty("_embedded")
    private CharacterEmbeddedDTO embedded;

    public WrapperCharacterDTO(CharacterEmbeddedDTO embedded) {
        this.embedded = embedded;
    }

    public WrapperCharacterDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperCharacterDTO that = (WrapperCharacterDTO) o;
        return Objects.equals(embedded, that.embedded);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(embedded);
    }
}
