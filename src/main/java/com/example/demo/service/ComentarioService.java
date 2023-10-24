package com.example.demo.service;

import com.example.demo.model.Comentario;
import com.example.demo.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    public Comentario getComentarioById(Long id) {
        Optional<Comentario> comentarioOptional = comentarioRepository.findById(id);
        if (comentarioOptional.isPresent()) {
            return comentarioOptional.get();
        }
        return null;
    }

    public Comentario createComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario updateComentario(Long id, Comentario comentario) {
        if (comentarioRepository.existsById(id)) {
            comentario.setId(id);
            return comentarioRepository.save(comentario);
        }
        return null;
    }

    public void deleteComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}
