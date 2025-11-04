package dev.matheuslf.desafio.inscritos.documentation;

import dev.matheuslf.desafio.inscritos.controller.request.UserRequest;
import dev.matheuslf.desafio.inscritos.controller.response.LoginResponse;
import dev.matheuslf.desafio.inscritos.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Authentication", description = "Recurso responsável por cadastro e login de usuários")
public interface AuthDocumentation {

    @Operation(summary = "Cadastro de usuários", description = "Cadastra os usuários para autententicação")
    @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso",
            content = @Content(schema = @Schema(implementation = UserResponse.class)))
    ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest request);

    @Operation(summary = "Login de usuário", description = "Realiza login do usuário para liberar outras rotas")
    @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso",
            content = @Content(schema = @Schema(implementation = LoginResponse.class)))
    ResponseEntity<LoginResponse> login(@Valid @RequestBody UserRequest request);

}
