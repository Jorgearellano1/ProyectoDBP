package com.example.demo.dto;

import java.util.Date;

public class JugadorDTO {

    private Long id;
    private String nombre;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String equipoActual;
    private String posicion;
    private String fotoUrl;

    // Constructores, getters y setters

    public JugadorDTO() {
    }

    public JugadorDTO(Long id, String nombre, Date fechaNacimiento, String nacionalidad, String equipoActual, String posicion, String fotoUrl) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.equipoActual = equipoActual;
        this.posicion = posicion;
        this.fotoUrl = fotoUrl;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEquipoActual() {
        return equipoActual;
    }

    public void setEquipoActual(String equipoActual) {
        this.equipoActual = equipoActual;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}
