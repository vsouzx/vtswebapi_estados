package br.vtsoliveira.vtswebapi_estados.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class EstadosResponse {

    private String nomeEstado;

    private String nomePais;
}
