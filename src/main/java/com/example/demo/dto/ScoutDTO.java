package com.example.demo.dto;

import java.util.Date;

public class ScoutDTO {

    private Long id;
    private String nombre;
    private String organizacion;
    private String pais;
    private Date fechaInicioActividad;

    // Constructores, getters y setters

    public ScoutDTO() {
    }

    public ScoutDTO(Long id, String nombre, String organizacion, String pais, Date fechaInicioActividad) {
        this.id = id;
        this.nombre = nombre;
        this.organizacion = organizacion;
        this.pais = pais;
        this.fechaInicioActividad = fechaInicioActividad;
    }

    // Getters y setters

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
