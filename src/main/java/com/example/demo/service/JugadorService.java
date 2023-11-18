package com.example.demo.service;

import com.example.demo.dto.JugadorDTO;
import com.example.demo.domain.Jugador;
import com.example.demo.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @Transactional
    public JugadorDTO crearJugador(JugadorDTO jugadorDTO) {
        Jugador jugador = new Jugador();

        Jugador nuevoJugador = jugadorRepository.save(jugador);
        return convertirAJugadorDTO(nuevoJugador);
    }

    @Transactional(readOnly = true)
    public List<JugadorDTO> obtenerTodosJugadores() {
        return jugadorRepository.findAll().stream()
                .map(this::convertirAJugadorDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public JugadorDTO obtenerJugadorPorId(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado."));
        return convertirAJugadorDTO(jugador);
    }

    @Transactional
    public JugadorDTO actualizarJugador(Long id, JugadorDTO jugadorDTO) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado."));

        Jugador jugadorActualizado = jugadorRepository.save(jugador);
        return convertirAJugadorDTO(jugadorActualizado);
    }

    @Transactional
    public void eliminarJugador(Long id) {
        jugadorRepository.deleteById(id);
    }

    private JugadorDTO convertirAJugadorDTO(Jugador jugador) {
        JugadorDTO jugadorDTO = new JugadorDTO();
        return jugadorDTO;
    }
}
