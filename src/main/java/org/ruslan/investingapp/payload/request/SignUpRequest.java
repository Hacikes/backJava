package org.ruslan.investingapp.payload.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignUpRequest implements Serializable {

    private final String email;
    private final String password;
}
