package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.Task;
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

    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> findTaskById(Long id) {
        return repository.findById(id);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public Project findProject (Project project) {
        Optional<Project> optionalProject = projectRepository.findById(project.getId());
        return optionalProject.orElse(null);
    }




}
