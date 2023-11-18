package com.example.demo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String nacionalidad;

    @Column(nullable = true)
    private String equipoActual;

    @Column(nullable = true)
    private String posicion;

    @Column(nullable = true)
    private String fotoUrl;

    // Constructores, getters y setters

    public Jugador() {
    }

    public Jugador(String nombre, Date fechaNacimiento, String nacionalidad, String equipoActual, String posicion, String fotoUrl) {
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

