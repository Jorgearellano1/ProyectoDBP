package com.example.demo.controller;

import com.example.demo.dto.JugadorDTO;
import com.example.demo.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    @Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @PostMapping
    public ResponseEntity<JugadorDTO> crearJugador(@Valid @RequestBody JugadorDTO jugadorDTO) {
        JugadorDTO nuevoJugador = jugadorService.crearJugador(jugadorDTO);
        return ResponseEntity.ok(nuevoJugador);
    }

    @GetMapping
    public ResponseEntity<List<JugadorDTO>> obtenerTodosJugadores() {
        List<JugadorDTO> jugadores = jugadorService.obtenerTodosJugadores();
        return ResponseEntity.ok(jugadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorDTO> obtenerJugadorPorId(@PathVariable Long id) {
        JugadorDTO jugador = jugadorService.obtenerJugadorPorId(id);
        return ResponseEntity.ok(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorDTO> actualizarJugador(@PathVariable Long id, @Valid @RequestBody JugadorDTO jugadorDTO) {
        JugadorDTO jugadorActualizado = jugadorService.actualizarJugador(id, jugadorDTO);
        return ResponseEntity.ok(jugadorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminarJugador(id);
        return ResponseEntity.ok("Jugador eliminado con éxito");
    }
}
