package co.com.bancolombia.usecase.verifyOwner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class VerifyOwnerCommand{
    private int userId;
}