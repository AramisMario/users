package co.com.bancolombia.usecase.createuser;
import co.com.bancolombia.model.baseUser.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class CreateUserCommand{
    private User user;
    private Integer idRole;
}