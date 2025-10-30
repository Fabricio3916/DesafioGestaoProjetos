package dev.matheuslf.desafio.inscritos.controller.request;

import dev.matheuslf.desafio.inscritos.entity.enums.Status;

public record UpdateStatusRequest(Status status) {
}
