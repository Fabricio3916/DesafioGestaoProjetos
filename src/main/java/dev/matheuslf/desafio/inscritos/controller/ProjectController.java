package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.controller.request.ProjectRequest;
import dev.matheuslf.desafio.inscritos.controller.response.ProjectResponse;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.mapper.ProjectMapper;
import dev.matheuslf.desafio.inscritos.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody ProjectRequest request) {
        Project project = service.saveProject(ProjectMapper.toEntity(request));
        return ResponseEntity.ok(ProjectMapper.toResponse(project));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> findAllProjects() {
        List<ProjectResponse> projects = service.findAllProjects().stream()
                .map(ProjectMapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.FOUND).body(projects);
    }

}
