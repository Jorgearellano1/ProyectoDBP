package com.example.demo.controller;

import com.example.demo.dto.ScoutDTO;
import com.example.demo.service.ScoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/scouts")
public class ScoutController {

    private final ScoutService scoutService;

    @Autowired
    public ScoutController(ScoutService scoutService) {
        this.scoutService = scoutService;
    }

    @PostMapping
    public ResponseEntity<ScoutDTO> crearScout(@Valid @RequestBody ScoutDTO scoutDTO) {
        ScoutDTO nuevoScout = scoutService.crearScout(scoutDTO);
        return ResponseEntity.ok(nuevoScout);
    }

    @GetMapping
    public ResponseEntity<List<ScoutDTO>> obtenerTodosScouts() {
        List<ScoutDTO> scouts = scoutService.obtenerTodosScouts();
        return ResponseEntity.ok(scouts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoutDTO> obtenerScoutPorId(@PathVariable Long id) {
        ScoutDTO scout = scoutService.obtenerScoutPorId(id);
        return ResponseEntity.ok(scout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScoutDTO> actualizarScout(@PathVariable Long id, @Valid @RequestBody ScoutDTO scoutDTO) {
        ScoutDTO scoutActualizado = scoutService.actualizarScout(id, scoutDTO);
        return ResponseEntity.ok(scoutActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarScout(@PathVariable Long id) {
        scoutService.eliminarScout(id);
        return ResponseEntity.ok("Scout eliminado con éxito");
    }
}
