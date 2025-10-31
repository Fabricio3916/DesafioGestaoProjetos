package dev.matheuslf.desafio.inscritos.controller.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id,
                           String username

) {}
