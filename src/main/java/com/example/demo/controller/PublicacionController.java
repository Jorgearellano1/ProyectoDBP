package com.example.demo.controller;

import com.example.demo.dto.PublicacionDTO;
import com.example.demo.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    private final PublicacionService publicacionService;

    @Autowired
    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public ResponseEntity<PublicacionDTO> crearPublicacion(@Valid @RequestBody PublicacionDTO publicacionDTO) {
        PublicacionDTO nuevaPublicacion = publicacionService.crearPublicacion(publicacionDTO);
        return ResponseEntity.ok(nuevaPublicacion);
    }

    @GetMapping
    public ResponseEntity<List<PublicacionDTO>> obtenerTodasPublicaciones() {
        List<PublicacionDTO> publicaciones = publicacionService.obtenerTodasPublicaciones();
        return ResponseEntity.ok(publicaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDTO> obtenerPublicacionPorId(@PathVariable Long id) {
        PublicacionDTO publicacion = publicacionService.obtenerPublicacionPorId(id);
        return ResponseEntity.ok(publicacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacionDTO> actualizarPublicacion(@PathVariable Long id, @Valid @RequestBody PublicacionDTO publicacionDTO) {
        PublicacionDTO publicacionActualizada = publicacionService.actualizarPublicacion(id, publicacionDTO);
        return ResponseEntity.ok(publicacionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminarPublicacion(id);
        return ResponseEntity.ok("Publicación eliminada con éxito");
    }
}
