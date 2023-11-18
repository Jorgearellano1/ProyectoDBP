package com.example.demo.dto;

import java.util.Date;

public class PublicacionDTO {

    private Long id;
    private String titulo;
    private String contenido;
    private Long autorId;
    private Date fechaCreacion;

    // Constructores, getters y setters

    public PublicacionDTO() {
    }

    public PublicacionDTO(Long id, String titulo, String contenido, Long autorId, Date fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.autorId = autorId;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
