package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.exception.ProjectNotFoundException;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project saveProject(Project project) {
        return repository.save(project);
    }

    public List<Project> findAllProjects() {
        return repository.findAll();
    }

    public Optional<Project> findProjectById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Projeto não foi encontrado.")));
    }

}
