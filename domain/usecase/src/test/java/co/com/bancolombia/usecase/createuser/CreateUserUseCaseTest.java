package co.com.bancolombia.usecase.createuser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.bancolombia.model.baseUser.User;
import co.com.bancolombia.model.baseUser.gateways.EncryptInterface;
import co.com.bancolombia.model.baseUser.gateways.UserRepository;
import co.com.bancolombia.model.role.Role;
import co.com.bancolombia.model.role.gateways.RoleRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

public class CreateUserUseCaseTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private EncryptInterface encrypt;

    private CreateUserUseCase createUserUseCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        createUserUseCase = new CreateUserUseCase(roleRepository, userRepository, encrypt);
    }

    @Test
    void testExecute() {

        Role role = Role.builder().id(1).name("Administrator").build();
        User user = User.builder()
                .id(1)
                .name("michael")
                .lastName("lastName")
                .email("email@gmail.com")
                .identificationDocument("12345678")
                .password("Jgiaa7TuhHJ6jfg")
                .birthDate("1998-06-14")
                .phone("3456237")
                .role(role)
                .build();

        when(userRepository.save(any())).thenReturn(user);
        when(encrypt.encrypt(user.getPassword())).thenReturn("encryptedpassword");
        when(roleRepository.findById(1)).thenReturn(role);

        CreateUserCommand createUserCommand = new CreateUserCommand(user, 1);
        User userCreated = createUserUseCase.execute(createUserCommand);

        assertEquals(user.getId(), userCreated.getId());
        assertEquals(user.getName(), userCreated.getName());

    }

    @Test
    void testUnderAge() {

        Role role = Role.builder().id(1).name("Administrator").build();
        User user = User.builder()
                .id(1)
                .name("michael")
                .lastName("lastName")
                .email("email@gmail.com")
                .identificationDocument("12345678")
                .password("Jgiaa7TuhHJ6jfg")
                .birthDate("2018-06-14")
                .phone("3456237")
                .role(role)
                .build();

        when(userRepository.save(any())).thenReturn(user);
        when(encrypt.encrypt(user.getPassword())).thenReturn("encryptedpassword");
        when(roleRepository.findById(1)).thenReturn(role);

        CreateUserCommand createUserCommand = new CreateUserCommand(user, 1);
        //User userCreated = createUserUseCase.execute(createUserCommand);

        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> {
            createUserUseCase.execute(createUserCommand);
        });

        assertEquals("El usuario es menor de edad", ex.getMessage());

    }

}
