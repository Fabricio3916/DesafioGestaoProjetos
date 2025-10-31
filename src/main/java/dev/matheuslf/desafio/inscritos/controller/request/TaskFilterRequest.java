package dev.matheuslf.desafio.inscritos.controller.request;

import dev.matheuslf.desafio.inscritos.entity.enums.Priority;
import dev.matheuslf.desafio.inscritos.entity.enums.Status;

public record TaskFilterRequest(Status status,
                                Priority priority,
                                Long projectId
) {}
