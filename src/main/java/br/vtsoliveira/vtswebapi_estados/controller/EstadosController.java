package br.vtsoliveira.vtswebapi_estados.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.vtsoliveira.vtswebapi_estados.dto.EstadosRequest;
import br.vtsoliveira.vtswebapi_estados.dto.EstadosResponse;
import br.vtsoliveira.vtswebapi_estados.service.EstadosService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("estados")
public class EstadosController {

    @Autowired
    private EstadosService estadosService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstadosResponse>> listarTodosOsEstados(){
        return ResponseEntity.ok(estadosService.acharTodos());
    }

    @GetMapping(value="{nomePais}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstadosResponse>> listarPorPais(@PathVariable("nomePais") String pais){
        return ResponseEntity.ok(estadosService.acharTodosEstadosPeloPais(pais));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadosResponse> cadastrarUmEstado(@Valid @RequestBody EstadosRequest request){
        return ResponseEntity.ok(estadosService.salvar(request));
    }
}
