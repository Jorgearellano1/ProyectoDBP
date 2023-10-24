package com.example.demo.service;

import com.example.demo.model.Publicacion;
import com.example.demo.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    public List<Publicacion> getAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    public Publicacion getPublicacionById(Long id) {
        Optional<Publicacion> publicacionOptional = publicacionRepository.findById(id);
        if (publicacionOptional.isPresent()) {
            return publicacionOptional.get();
        }
        return null;
    }

    public Publicacion createPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public Publicacion updatePublicacion(Long id, Publicacion publicacion) {
        if (publicacionRepository.existsById(id)) {
            publicacion.setId(id);
            return publicacionRepository.save(publicacion);
        }
        return null;
    }

    public void deletePublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }
}
