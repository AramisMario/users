package co.com.bancolombia.usecase.createclient;

import co.com.bancolombia.model.baseUser.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor

public class CreateClientCommand {
    private User user;
}
