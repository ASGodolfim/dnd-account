package dnd.br.account.map;

import dnd.br.account.dto.CharacterDTO;
import dnd.br.account.dto.UserDTO;
import dnd.br.account.entity.Character;
import dnd.br.account.entity.User;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private static final ModelMapper charMapper = new ModelMapper();
    private static final ModelMapper userMapper = new ModelMapper();

    static {
        charMapper.createTypeMap(Character.class, CharacterDTO.class)
                .addMapping(Character::getId, CharacterDTO::setId);
        charMapper.createTypeMap(CharacterDTO.class, Character.class)
                .addMapping(CharacterDTO::getId, Character::setId);
        userMapper.createTypeMap(User.class, UserDTO.class)
                .addMapping(User::getId, UserDTO::setId);
        userMapper.createTypeMap(UserDTO.class, User.class)
                .addMapping(UserDTO::getId, User::setId);

    }

    public static <O, D> D parseChar(O origin, Class<D> destination){
        return charMapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListChar(List<O> origin, Class<D> destination){

        List<D> destinationObj = new ArrayList<>();
        for (O o:origin){
            destinationObj.add(charMapper.map(o, destination));
        }
        return destinationObj;
    }
    public static <O, D> D parseUser(O origin, Class<D> destination){
        return userMapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListUser(List<O> origin, Class<D> destination){

        List<D> destinationObj = new ArrayList<>();
        for (O o:origin){
            destinationObj.add(userMapper.map(o, destination));
        }
        return destinationObj;
    }


}
