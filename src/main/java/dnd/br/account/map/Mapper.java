package dnd.br.account.map;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.entity.Character;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private static ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(Character.class, CharacterDTO.class)
                .addMapping(Character::getId, CharacterDTO::setId);
        mapper.createTypeMap(CharacterDTO.class, Character.class)
                .addMapping(CharacterDTO::getId, Character::setId);
    }

    public static <O, D> D parseObj(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObj(List<O> origin, Class<D> destination){

        List<D> destinationObj = new ArrayList<>();
        for (O o:origin){
            destinationObj.add(mapper.map(o, destination));
        }
        return destinationObj;
    }

}
