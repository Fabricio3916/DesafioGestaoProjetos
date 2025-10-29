package dev.matheuslf.desafio.inscritos.controller.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ProjectResponse(Long id,
                              String name,
                              String description,
                              LocalDate startDate,
                              LocalDate endDate,
                              List<TaskResponse> tasks
) {}
