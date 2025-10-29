package dev.matheuslf.desafio.inscritos.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ProjectRequest(@Size(min = 3, max = 100) @NotNull(message = "Nome do projeto não pode ser vazio")
                             String name,
                             String description

) {}
