package com.example.demo.repository;

import com.example.demo.domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    List<Publicacion> findByTituloContaining(String titulo);

    List<Publicacion> findByJugadorId(Long jugadorId);

    List<Publicacion> findByFechaPublicacionBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
