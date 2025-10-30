package dev.matheuslf.desafio.inscritos.controller.request;

import dev.matheuslf.desafio.inscritos.entity.enums.Status;
import jakarta.validation.constraints.NotNull;

public record UpdateStatusRequest(@NotNull(message = "Status não pode ser nulo")
                                  Status status
) {}
