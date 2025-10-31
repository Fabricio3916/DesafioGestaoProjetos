package dev.matheuslf.desafio.inscritos.controller.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(@NotBlank(message = "Usuário não atende requisitos")
                              String username,
                          @NotBlank(message = "Senha não atende requisitos")
                              String password
) {}
