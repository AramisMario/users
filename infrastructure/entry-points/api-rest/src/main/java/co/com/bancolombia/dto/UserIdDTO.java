package co.com.bancolombia.dto;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
//import co.com.bancolombia.model.role.Role;
@Getter
@Setter
public class UserIdDTO {
    @Positive
    private int userId;
}
