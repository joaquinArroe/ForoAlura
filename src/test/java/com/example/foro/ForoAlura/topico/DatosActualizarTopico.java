package com.example.foro.ForoAlura.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje, String fecha_creacion) {
}

