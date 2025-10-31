package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.controller.request.TaskFilterRequest;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.Task;
import dev.matheuslf.desafio.inscritos.entity.enums.Priority;
import dev.matheuslf.desafio.inscritos.entity.enums.Status;
import dev.matheuslf.desafio.inscritos.exception.TaskNotFoundException;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    public Task saveTask(Task task) {
        Project project = findProject(task.getProject());
        task.setProject(project);
        return repository.save(task);
    }

    public List<Task> findTasks(TaskFilterRequest request) {
        return repository.findByFilters(request.status(),request.priority(),request.projectId());
    }

    public Optional<Task> findTaskById(Long id) {
        return repository.findById(id);
    }

    public Task updateStatus(Long id, Status newStatus) {
        Task task = findTaskById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task com id " + id + " não existe."));
        task.setStatus(newStatus);
        return repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public Project findProject (Project project) {
        Optional<Project> optionalProject = projectRepository.findById(project.getId());
        return optionalProject.orElse(null);
    }




}
