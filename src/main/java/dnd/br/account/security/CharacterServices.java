package dnd.br.account.security;

import dnd.br.account.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServices {

    @Autowired
    CharacterRepository repository;




}
