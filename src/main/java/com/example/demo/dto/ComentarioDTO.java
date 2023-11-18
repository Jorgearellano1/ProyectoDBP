package com.example.demo.dto;

public class ComentarioDTO {

    private Long id;
    private String contenido;
    private Long autorId; // ID del usuario que hizo el comentario


    public ComentarioDTO() {
    }

    public ComentarioDTO(Long id, String contenido, Long autorId) {
        this.id = id;
        this.contenido = contenido;
        this.autorId = autorId;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
