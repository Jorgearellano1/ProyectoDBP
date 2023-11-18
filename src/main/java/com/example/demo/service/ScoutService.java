package com.example.demo.service;

import com.example.demo.dto.ScoutDTO;
import com.example.demo.domain.Scout;
import com.example.demo.repository.ScoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoutService {

    private final ScoutRepository scoutRepository;

    @Autowired
    public ScoutService(ScoutRepository scoutRepository) {
        this.scoutRepository = scoutRepository;
    }

    @Transactional
    public ScoutDTO crearScout(ScoutDTO scoutDTO) {
        Scout scout = new Scout();

        Scout nuevoScout = scoutRepository.save(scout);
        return convertirAScoutDTO(nuevoScout);
    }

    @Transactional(readOnly = true)
    public List<ScoutDTO> obtenerTodosScouts() {
        return scoutRepository.findAll().stream()
                .map(this::convertirAScoutDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ScoutDTO obtenerScoutPorId(Long id) {
        Scout scout = scoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scout no encontrado."));
        return convertirAScoutDTO(scout);
    }

    @Transactional
    public ScoutDTO actualizarScout(Long id, ScoutDTO scoutDTO) {
        Scout scout = scoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scout no encontrado."));

        Scout scoutActualizado = scoutRepository.save(scout);
        return convertirAScoutDTO(scoutActualizado);
    }

    @Transactional
    public void eliminarScout(Long id) {
        scoutRepository.deleteById(id);
    }

    private ScoutDTO convertirAScoutDTO(Scout scout) {
        ScoutDTO scoutDTO = new ScoutDTO();
        return scoutDTO;
    }
}
