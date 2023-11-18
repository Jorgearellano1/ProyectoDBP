package com.example.demo.controller;

import com.example.demo.dto.ComentarioDTO;
import com.example.demo.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @Autowired
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> crearComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) {
        ComentarioDTO nuevoComentario = comentarioService.crearComentario(comentarioDTO);
        return ResponseEntity.ok(nuevoComentario);
    }

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> obtenerTodosComentarios() {
        List<ComentarioDTO> comentarios = comentarioService.obtenerTodosComentarios();
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> obtenerComentarioPorId(@PathVariable Long id) {
        ComentarioDTO comentario = comentarioService.obtenerComentarioPorId(id);
        return ResponseEntity.ok(comentario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioDTO> actualizarComentario(@PathVariable Long id, @Valid @RequestBody ComentarioDTO comentarioDTO) {
        ComentarioDTO comentarioActualizado = comentarioService.actualizarComentario(id, comentarioDTO);
        return ResponseEntity.ok(comentarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return ResponseEntity.ok("Comentario eliminado con éxito");
    }
}
