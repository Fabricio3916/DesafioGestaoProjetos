package dev.matheuslf.desafio.inscritos.documentation;

import dev.matheuslf.desafio.inscritos.controller.request.ProjectRequest;
import dev.matheuslf.desafio.inscritos.controller.response.ProjectResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Project", description = "Recurso responsavel pelo gerenciamento dos projetos.")
public interface ProjectDocumentation {

    @Operation(summary = "Criar Projeto", description = "Criação de projetos dentro da aplicação",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Projeto salvo com sucesso",
            content = @Content(schema = @Schema(implementation = ProjectResponse.class)))
    ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody ProjectRequest request);

    @Operation(summary = "Listar projetos", description = "Lista todos os projetos cadastrados",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Projetos encontrados com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProjectResponse.class))))
    ResponseEntity<List<ProjectResponse>> findAllProjects();

}
