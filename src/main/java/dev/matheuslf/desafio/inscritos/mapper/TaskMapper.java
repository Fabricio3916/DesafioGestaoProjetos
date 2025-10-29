package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.controller.request.TaskRequest;
import dev.matheuslf.desafio.inscritos.controller.response.TaskResponse;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.Task;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TaskMapper {

    public static Task toEntity(TaskRequest request) {

        Project project = Project.builder().id(request.project()).build();

        return Task.builder()
                .title(request.title())
                .description(request.description())
                .status(request.status())
                .priority(request.priority())
                .dueDate(request.dueDate())
                .project(project)
                .build();
    }

    public static TaskResponse toResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .dueDate(task.getDueDate())
                .project(task.getProject())
                .build();
    }


}
