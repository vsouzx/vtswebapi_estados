package br.vtsoliveira.vtswebapi_estados.service;

import br.vtsoliveira.vtswebapi_estados.database.model.Estados;
import br.vtsoliveira.vtswebapi_estados.database.repository.IEstadosRepository;
import br.vtsoliveira.vtswebapi_estados.dto.EstadosRequest;
import br.vtsoliveira.vtswebapi_estados.dto.EstadosResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadosService {

    @Autowired
    private IEstadosRepository estadosRepository;

    public List<EstadosResponse> acharTodos(){
        List<EstadosResponse> response = new ArrayList<EstadosResponse>();
        estadosRepository.findAll().stream().forEach(e -> {
            response.add(EstadosResponse.builder()
                                        .nomeEstado(e.getNomeEstado())
                                        .nomePais(e.getNomePais())
                                        .build());
        });

        return response;
    }

    public List<EstadosResponse> acharTodosEstadosPeloPais(String pais){
        List<EstadosResponse> response = new ArrayList<EstadosResponse>();
        estadosRepository.findAllByNomePais(pais).stream().forEach(e -> {
            response.add(EstadosResponse.builder()
                                        .nomeEstado(e.getNomeEstado())
                                        .nomePais(e.getNomePais())
                                        .build());
        });

        return response;
    }

    public EstadosResponse salvar(EstadosRequest request){
        estadosRepository.save(Estados.builder()
                                      .nomeEstado(request.getNomeEstado())
                                      .nomePais(request.getNomePais())
                                      .build());
        return EstadosResponse.builder()
                              .nomeEstado(request.getNomeEstado())
                              .nomePais(request.getNomePais())
                              .build();
    }
}
