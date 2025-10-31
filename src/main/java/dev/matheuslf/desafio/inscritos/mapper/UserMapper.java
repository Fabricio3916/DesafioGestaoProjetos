package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.controller.request.UserRequest;
import dev.matheuslf.desafio.inscritos.controller.response.UserResponse;
import dev.matheuslf.desafio.inscritos.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public User toUser(UserRequest request) {
        return  User.builder()
                .username(request.username())
                .password(request.password())
                .build();
    }

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .id(user.getId())
                .build();
    }

}
