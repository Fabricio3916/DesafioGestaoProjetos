package dev.matheuslf.desafio.inscritos.controller.request;

import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.enums.Priority;
import dev.matheuslf.desafio.inscritos.entity.enums.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskRequest(@Size(min = 5, max = 150) @NotNull(message = "Titulo não pode ser vazio.")
                          String title,
                          String description,
                          @NotNull(message = "Status não pode ser nulo")
                          Status status,
                          @NotNull(message = "Priority não pode ser nulo")
                          Priority priority,
                          LocalDate dueDate,
                          Long project
) {}
