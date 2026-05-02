package co.com.bancolombia.jpa.helper;

import co.com.bancolombia.jpa.user.JPAUserRepository;
import co.com.bancolombia.jpa.user.JPAUserRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;
//import org.springframework.data.domain.Example;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

import javax.naming.spi.DirStateFactory.Result;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import co.com.bancolombia.jpa.user.userEntity.UserEntity;
import co.com.bancolombia.model.baseUser.User;

class AdapterOperationsTest {

    @Mock
    private JPAUserRepository repository;

    @Mock
    private ObjectMapper objectMapper;

    private JPAUserRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.adapter = new JPAUserRepositoryAdapter(repository, objectMapper);
    }

    private User buildUser() {
        return User.builder()
                .id(1)
                .name("name")
                .lastName("lastName")
                .email("email@gmail.com")
                .identificationDocument("12345678")
                .password("Jgiaa7TuhHJ6jfg")
                .birthDate("1998-06-14")
                .phone("3456237")
                .role(null)
                .build();
    }

    private UserEntity buildUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setName("name");
        userEntity.setLastName("lastName");
        userEntity.setEmail("email@gmail.com");
        userEntity.setIdentificationDocument("12345678");
        userEntity.setPassword("Jgiaa7TuhHJ6jfg");
        userEntity.setBirthDate("1998-06-14");
        userEntity.setPhone("3456237");
        userEntity.setRole(null);
        return userEntity;
    }

    @Test
    void testSave() {

        when(objectMapper.map(any(), any())).thenReturn(this.buildUserEntity()).thenReturn(this.buildUser());
        when(repository.save(any())).thenReturn(this.buildUserEntity());

        User user = this.buildUser();

        User result = adapter.save(user);
        assertEquals(result.getId(), user.getId());
        assertEquals(result.getName(), user.getName());
        assertEquals(result.getLastName(), user.getLastName());
        assertEquals(result.getPhone(), user.getPhone());

        // Exception ex = assertThrows(RuntimeException.class, () -> {
        // adapter.save(user);
        // });
        // System.out.println(ex.getMessage());

        // assertDoesNotThrow(() -> {
        // adapter.save(user);
        // });

        // verify(repository, times(2)).save(any());

        // ArgumentCaptor<UserEntity> captor =
        // ArgumentCaptor.forClass(UserEntity.class);
        // verify(repository).save(captor.capture());
        // UserEntity captured = captor.getValue();
        // System.out.println(captured.getEmail());

    }

    @Test
    void testSaveAllEntities() {

        User user = this.buildUser();
        UserEntity userEntity = this.buildUserEntity();

        List<User> objectValues = List.of(user);
        List<UserEntity> entityValues = List.of(userEntity);

        when(objectMapper.map(any(), any())).thenReturn(userEntity).thenReturn(user);
        when(repository.saveAll(entityValues)).thenReturn(entityValues);

        List<User> result = adapter.saveAllEntities(objectValues);

        assertEquals(result.get(0).getId(), objectValues.get(0).getId());
    }

    @Test
    void testFindById() {

        User user = this.buildUser();
        UserEntity userEntity = this.buildUserEntity();

        when(objectMapper.map(any(), any())).thenReturn(user);
        when(repository.save(any())).thenReturn(userEntity);

        when(repository.findById(1)).thenReturn(Optional.of(userEntity));

        Object result = adapter.findById(1);

        assertEquals(result, user);
    }

    @Test
    void testFindAll() {

        User user = this.buildUser();
        UserEntity userEntity = this.buildUserEntity();

        List<User> users = List.of(user);
        List<UserEntity> userEntities = List.of(userEntity);

        when(objectMapper.map(any(), any())).thenReturn(this.buildUser());
        when(repository.findAll()).thenReturn(userEntities);


        List<User> result = adapter.findAll();

        assertEquals(result.get(0).getId(), users.get(0).getId());

    }

    
    @Test
    void testFindByExample() {

        User user = User.builder().name("name").build();

        List<UserEntity> userEntities = List.of(this.buildUserEntity());

        when(objectMapper.map(any(), any())).thenReturn(this.buildUser());
        when(repository.findAll(any(Example.class))).thenReturn(userEntities);

        List<User> result = adapter.findByExample(user);

        assertEquals(result.get(0).getName(), user.getName());
    }

}
