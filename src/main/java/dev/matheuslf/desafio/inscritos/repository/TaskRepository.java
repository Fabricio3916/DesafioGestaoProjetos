package dev.matheuslf.desafio.inscritos.repository;

import dev.matheuslf.desafio.inscritos.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
