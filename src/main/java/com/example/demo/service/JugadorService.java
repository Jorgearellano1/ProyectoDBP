package com.example.demo.service;

import com.example.demo.model.Jugador;
import com.example.demo.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador getJugadorById(Long id) {
        Optional<Jugador> jugadorOptional = jugadorRepository.findById(id);
        return jugadorOptional.orElse(null);
    }

    public Jugador createJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador updateJugador(Long id, Jugador jugador) {
        if (jugadorRepository.existsById(id)) {
            jugador.setId(id);
            return jugadorRepository.save(jugador);
        } else {
            return null;
        }
    }

    public boolean deleteJugador(Long id) {
        if (jugadorRepository.existsById(id)) {
            jugadorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
