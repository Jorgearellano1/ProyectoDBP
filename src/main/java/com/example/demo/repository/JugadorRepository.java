package com.example.demo.repository;

import com.example.demo.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador> findByEquipoActual(String equipoActual);

    List<Jugador> findByFechaNacimientoBetween(Date inicio, Date fin);

    List<Jugador> findByNacionalidad(String nacionalidad);

    List<Jugador> findByPosicion(String posicion);

}
