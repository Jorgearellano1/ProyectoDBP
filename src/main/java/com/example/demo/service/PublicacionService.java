package com.example.demo.service;

import com.example.demo.dto.PublicacionDTO;
import com.example.demo.domain.Publicacion;
import com.example.demo.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    @Autowired
    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    @Transactional
    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = new Publicacion();

        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);
        return convertirAPublicacionDTO(nuevaPublicacion);
    }

    @Transactional(readOnly = true)
    public List<PublicacionDTO> obtenerTodasPublicaciones() {
        return publicacionRepository.findAll().stream()
                .map(this::convertirAPublicacionDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PublicacionDTO obtenerPublicacionPorId(Long id) {
        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada."));
        return convertirAPublicacionDTO(publicacion);
    }

    @Transactional
    public PublicacionDTO actualizarPublicacion(Long id, PublicacionDTO publicacionDTO) {
        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada."));

        Publicacion publicacionActualizada = publicacionRepository.save(publicacion);
        return convertirAPublicacionDTO(publicacionActualizada);
    }

    @Transactional
    public void eliminarPublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }

    private PublicacionDTO convertirAPublicacionDTO(Publicacion publicacion) {
        PublicacionDTO publicacionDTO = new PublicacionDTO();
        return publicacionDTO;
    }
}
