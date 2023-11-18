package com.example.demo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "scouts")
public class Scout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String organizacion;

    @Column(nullable = true)
    private String pais;

    @Column(nullable = true)
    private Date fechaInicioActividad;


    public Scout() {
    }

    public Scout(String nombre, String organizacion, String pais, Date fechaInicioActividad) {
        this.nombre = nombre;
        this.organizacion = organizacion;
        this.pais = pais;
        this.fechaInicioActividad = fechaInicioActividad;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaInicioActividad() {
        return fechaInicioActividad;
    }

    public void setFechaInicioActividad(Date fechaInicioActividad) {
        this.fechaInicioActividad = fechaInicioActividad;
    }
}
