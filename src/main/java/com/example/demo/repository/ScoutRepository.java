package com.example.demo.repository;

import com.example.demo.domain.Scout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScoutRepository extends JpaRepository<Scout, Long> {

    List<Scout> findByNombreContaining(String nombre);

    List<Scout> findByOrganizacion(String organizacion);

    List<Scout> findByPais(String pais);

    List<Scout> findByFechaInicioActividadAfter(Date fecha);

}
