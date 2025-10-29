package dev.matheuslf.desafio.inscritos.controller.response;

import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.enums.Priority;
import dev.matheuslf.desafio.inscritos.entity.enums.Status;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record TaskResponse(Long id,
                           String title,
                           String description,
                           Status status,
                           Priority priority,
                           LocalDate dueDate,
                           Project project
) {}
