package br.vtsoliveira.vtswebapi_estados.controller;

import br.vtsoliveira.vtswebapi_estados.config.websocket.NotificationWebSocket;
import java.util.List;

import javax.validation.Valid;

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

@RestController
@RequestMapping(value = "/estados")
public class EstadosController {

    private final EstadosService estadosService;
    private final NotificationWebSocket notificationWebSocket;

    public EstadosController(EstadosService estadosService,
                             NotificationWebSocket notificationWebSocket) {
        this.estadosService = estadosService;
        this.notificationWebSocket = notificationWebSocket;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstadosResponse>> listarTodosOsEstados() throws Exception {
        notificationWebSocket.notifyNewNotification();
        return ResponseEntity.ok(estadosService.acharTodos());
    }

    @GetMapping(value = "/{nomePais}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstadosResponse>> listarPorPais(@PathVariable("nomePais") String pais) throws Exception {
        notificationWebSocket.notifyNewNotification();
        return ResponseEntity.ok(estadosService.acharTodosEstadosPeloPais(pais));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadosResponse> cadastrarUmEstado(@Valid @RequestBody EstadosRequest request) throws Exception {
        notificationWebSocket.notifyNewNotification();
        return ResponseEntity.ok(estadosService.salvar(request));
    }
}
