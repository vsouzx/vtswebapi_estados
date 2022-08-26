package br.vtsoliveira.vtswebapi_estados.database.repository;

import br.vtsoliveira.vtswebapi_estados.database.model.Estados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadosRepository extends JpaRepository<Estados, Integer> {

    List<Estados> findAllByNomePais(String nomePais);
}
