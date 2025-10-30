package dev.matheuslf.desafio.inscritos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private String description;

    @CreationTimestamp
    private LocalDate startDate;

    private LocalDate endDate;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

}
