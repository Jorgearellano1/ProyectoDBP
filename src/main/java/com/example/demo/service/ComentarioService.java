package com.example.demo.service;

import com.example.demo.dto.ComentarioDTO;
import com.example.demo.domain.Comentario;
import com.example.demo.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Transactional
    public ComentarioDTO crearComentario(ComentarioDTO comentarioDTO) {
        Comentario comentario = new Comentario();

        Comentario nuevoComentario = comentarioRepository.save(comentario);
        return convertirAComentarioDTO(nuevoComentario);
    }

    @Transactional(readOnly = true)
    public List<ComentarioDTO> obtenerTodosComentarios() {
        return comentarioRepository.findAll().stream()
                .map(this::convertirAComentarioDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ComentarioDTO obtenerComentarioPorId(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado."));
        return convertirAComentarioDTO(comentario);
    }

    @Transactional
    public ComentarioDTO actualizarComentario(Long id, ComentarioDTO comentarioDTO) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado."));

        Comentario comentarioActualizado = comentarioRepository.save(comentario);
        return convertirAComentarioDTO(comentarioActualizado);
    }

    @Transactional
    public void eliminarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }

    private ComentarioDTO convertirAComentarioDTO(Comentario comentario) {
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        return comentarioDTO;
    }
}
