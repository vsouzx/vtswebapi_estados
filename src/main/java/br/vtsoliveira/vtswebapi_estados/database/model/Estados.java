package br.vtsoliveira.vtswebapi_estados.database.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "estados")
@Builder
public class Estados implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome_estado")
    private String nomeEstado;

    @Column(name = "nome_pais")
    private String nomePais;
}
