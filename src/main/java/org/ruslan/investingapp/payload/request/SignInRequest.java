package org.ruslan.investingapp.payload.request;

import lombok.Data;

@Data
public class SignInRequest {

    private final String email;
    private final String password;
}
