package br.vtsoliveira.vtswebapi_estados.dto;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class EstadosRequest {

    @NotBlank
    private String nomeEstado;

    @NotBlank
    private String nomePais;
}
