package dnd.br.account.entity.junit.mockito.services;

import dnd.br.account.config.repository.UserRepository;
import dnd.br.account.config.services.UserServices;
import dnd.br.account.dto.UserDTO;
import dnd.br.account.entity.User;
import dnd.br.account.unittests.mocks.MockUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class UserServicesTest {

    MockUser input;

    @InjectMocks
    private UserServices services;

    @Mock
    UserRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception{
        input = new MockUser();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() throws Exception{
        User persisted = input.mockEntity(1);

        UserDTO dto = input.mockDTO(1);

        when(repository.save(any(User.class))).thenReturn(persisted);

        UserDTO result = services.createUser(dto);

        assertNotNull(result);
        assertEquals(Long.valueOf(1L), result.getId());
        assertEquals("Test username1", result.getUser_name());
        assertEquals("Test password1", result.getPassword());
        assertEquals("Test name1", result.getName());
        assertEquals("Test email1", result.getEmail());
        assertEquals(Integer.valueOf(1), result.getAge());
    }
}
