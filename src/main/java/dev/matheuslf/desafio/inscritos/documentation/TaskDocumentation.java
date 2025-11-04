package dev.matheuslf.desafio.inscritos.documentation;

import dev.matheuslf.desafio.inscritos.controller.request.TaskFilterRequest;
import dev.matheuslf.desafio.inscritos.controller.request.TaskRequest;
import dev.matheuslf.desafio.inscritos.controller.request.UpdateStatusRequest;
import dev.matheuslf.desafio.inscritos.controller.response.TaskResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.internal.build.AllowNonPortable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Task", description = "Recurso que gerencia as tarefas atreladas aos projetos")
public interface TaskDocumentation {

    @Operation(summary = "Cria tarefa", description = "Realiza o cadastro das tarefas",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso",
            content = @Content(schema = @Schema(implementation = TaskResponse.class)))
    ResponseEntity<TaskResponse> createTask(@RequestBody @Valid TaskRequest request);

    @Operation(summary = "Listar tarefas", description = "Lista todas as tarefas com filtros opcionais",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso",
    content = @Content(array = @ArraySchema(schema = @Schema(implementation = TaskResponse.class))))
    ResponseEntity<List<TaskResponse>> findAllTasks(TaskFilterRequest request);

    @Operation(summary = "Atualiza status da tarefa", description = "Realiza o update do status da tarefa",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso",
            content = @Content(schema = @Schema(implementation = TaskResponse.class)))
    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada", content = @Content())
    ResponseEntity<TaskResponse> updateTaskStatus(
            @PathVariable Long id,
            @RequestBody @Valid UpdateStatusRequest request);

    @Operation(summary = "Deleta tarefa", description = "Realiza deleçao da tarefa",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Tarefa deletada com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada", content = @Content())
    ResponseEntity<Void> deleteTask(@PathVariable Long id);

}
