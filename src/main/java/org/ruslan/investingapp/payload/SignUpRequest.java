package org.ruslan.investingapp.payload;

import lombok.Data;

@Data
public class SignUpRequest {

    private String email;
    private String username;
    private String password;
}
