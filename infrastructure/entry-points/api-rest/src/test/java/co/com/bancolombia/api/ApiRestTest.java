package co.com.bancolombia.api;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.web.context.WebApplicationContext;
import co.com.bancolombia.api.ApiResponseBody;
import co.com.bancolombia.dto.UserDTO;
import co.com.bancolombia.dto.UserIdDTO;
import co.com.bancolombia.exceptions.UserNotOwnerException;
import co.com.bancolombia.model.baseUser.User;
import co.com.bancolombia.model.role.Role;
import co.com.bancolombia.usecase.createuser.CreateUserUseCase;
import co.com.bancolombia.usecase.verifyOwner.VerifyOwnerUseCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = TestConfig.class)
class ApiRestTest {

    @Autowired
    private WebApplicationContext context;

    private RestTestClient client;

    @MockitoBean
    private CreateUserUseCase createUserCase;

    @MockitoBean
    private VerifyOwnerUseCase verifyOwnerUseCase;

    @BeforeEach
    void setup() {
        client = RestTestClient.bindToApplicationContext(context).build();
    }

    @Test
    void shouldReturnValueFromCreateUserUseCase() {

        User user = User.builder()
                .id(1)
                .name("name")
                .lastName("lastName")
                .email("email@gmail.com")
                .identificationDocument("12345678")
                .password("Jgiaa7TuhHJ6jfg")
                .birthDate("1998-06-14")
                .phone("3456237")
                .role(new Role(1, "Administrator"))
                .build();

        UserDTO userDTO = new UserDTO();
        userDTO.setName("name");
        userDTO.setLastName("lastName");
        userDTO.setEmail("email@gmail.com");
        userDTO.setIdentificationDocument("12345678");
        userDTO.setIdRole(1);
        userDTO.setPassword("Jgiaa7TuhHJ6jfg");
        userDTO.setPhone("3456237");
        userDTO.setBirthDate("1998-06-14");

        when(createUserCase.execute(any())).thenReturn(user);

        client.post()
                .uri("/api/createuser/path")
                .body(userDTO)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(new ParameterizedTypeReference<ApiResponseBody<User>>() {
                }).value(response -> {
                    User data = response.getData();
                    assertEquals(data.getId(), user.getId());
                    assertEquals(data.getName(), user.getName());
                });
    }

    @Test
    void shouldReturnNotFoundForInvalidPath() {
        client.post()
                .uri("/api/usecase/invalid")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void shouldReturnValueFromVerifyOwnerUseCase() {

        User user = User.builder()
                .id(1)
                .name("name")
                .lastName("lastName")
                .email("email@gmail.com")
                .identificationDocument("12345678")
                .password("Jgiaa7TuhHJ6jfg")
                .birthDate("1998-06-14")
                .phone("3456237")
                .role(new Role(3, "Owner"))
                .build();

        UserIdDTO userIdDTO = new UserIdDTO();
        userIdDTO.setUserId(1);

        when(verifyOwnerUseCase.execute(any())).thenReturn(user);

        client.post()
                .uri("/api/verifyowner/path")
                .body(userIdDTO)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<ApiResponseBody<User>>() {
                }).value(response -> {
                    User data = response.getData();
                    assertEquals(user.getId(), data.getId());
                    assertEquals(user.getName(), data.getName());
                });

    }

    @Test
    void shouldReturnUserNotOwnerFromVerifyOwnerUseCase() {

        UserIdDTO userIdDTO = new UserIdDTO();
        userIdDTO.setUserId(1);

        when(verifyOwnerUseCase.execute(any())).thenThrow(new UserNotOwnerException());

        client.post()
                .uri("/api/verifyowner/path")
                .body(userIdDTO)
                .exchange()
                .expectStatus().is4xxClientError()
                .expectBody(ApiResponseBody.class)
                .value(response -> {
                    assertEquals(response.getCode(), "UNPROCESSABLE_CONTENT");
                });
    }
}
