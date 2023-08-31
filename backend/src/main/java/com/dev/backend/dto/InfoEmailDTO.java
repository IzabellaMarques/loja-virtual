package com.dev.backend.dto;

import lombok.Data;


@Data
public class InfoEmailDTO {

    private String destinatario;
    private String titulo;
    private String mensagem;
}
