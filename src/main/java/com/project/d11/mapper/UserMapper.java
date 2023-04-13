package com.project.d11.mapper;


import com.project.d11.jpa.entities.UserEntity;
import com.project.d11.models.request.OnboardUserRequest;
import com.project.d11.models.response.OnboardUserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
UserEntity map(OnboardUserRequest onboardUserRequest);

OnboardUserResponse map(UserEntity userEntity);
}
