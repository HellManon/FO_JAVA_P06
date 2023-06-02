package dto;

import lombok.Data;

@Data
public class LoginResponseDTO {

    private String accessToken;
    private String tokenType;

    public LoginResponseDTO (String accessToken, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public LoginResponseDTO () {

    }
}
