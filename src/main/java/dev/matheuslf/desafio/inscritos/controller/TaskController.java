package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.controller.request.TaskFilterRequest;
import dev.matheuslf.desafio.inscritos.controller.request.TaskRequest;
import dev.matheuslf.desafio.inscritos.controller.request.UpdateStatusRequest;
import dev.matheuslf.desafio.inscritos.controller.response.TaskResponse;
import dev.matheuslf.desafio.inscritos.entity.Task;
import dev.matheuslf.desafio.inscritos.entity.enums.Priority;
import dev.matheuslf.desafio.inscritos.entity.enums.Status;
import dev.matheuslf.desafio.inscritos.mapper.TaskMapper;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import jakarta.validation.Valid;
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
    public ResponseEntity<TaskResponse> createTask(@RequestBody @Valid TaskRequest request) {
        Task task = service.saveTask(TaskMapper.toEntity(request));
        return ResponseEntity.ok(TaskMapper.toResponse(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findAllTasks(TaskFilterRequest request){
        List<TaskResponse> tasks = service.findTasks(request).stream()
                .map(TaskMapper::toResponse)
                .toList();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponse> updateTaskStatus(
            @PathVariable Long id,
            @RequestBody @Valid UpdateStatusRequest request) {

        Task updatedTask = service.updateStatus(id, request.status());
        return ResponseEntity.ok(TaskMapper.toResponse(updatedTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
