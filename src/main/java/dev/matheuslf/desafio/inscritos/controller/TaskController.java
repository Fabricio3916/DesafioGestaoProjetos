package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.controller.request.TaskRequest;
import dev.matheuslf.desafio.inscritos.controller.response.TaskResponse;
import dev.matheuslf.desafio.inscritos.entity.Task;
import dev.matheuslf.desafio.inscritos.mapper.TaskMapper;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) {
        Task task = service.saveTask(TaskMapper.toEntity(request));
        return ResponseEntity.ok(TaskMapper.toResponse(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findAllTasks() {
        List<TaskResponse> tasks = service.findAllTasks().stream()
                .map(TaskMapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.FOUND).body(tasks);

    }

}
