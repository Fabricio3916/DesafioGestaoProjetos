package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.controller.request.ProjectRequest;
import dev.matheuslf.desafio.inscritos.controller.response.ProjectResponse;
import dev.matheuslf.desafio.inscritos.controller.response.TaskResponse;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class ProjectMapper {

    public static Project toEntity(ProjectRequest request) {

        return Project.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }

    public static ProjectResponse toResponse(Project project) {

        List<TaskResponse> tasks = project.getTasks() != null
                ? project.getTasks().stream().map(TaskMapper::toResponse).toList()
                : Collections.emptyList();

        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .tasks(tasks)
                .build();
    }


}
