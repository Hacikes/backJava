package org.ruslan.investingapp.mapper;

import org.mapstruct.Mapper;
import org.ruslan.investingapp.model.User;
import org.ruslan.investingapp.payload.request.SignUpRequest;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignUpRequest request);
}
