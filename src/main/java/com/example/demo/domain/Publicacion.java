package com.example.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String contenido;
    private LocalDateTime fechaPublicacion;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @ManyToOne
    @JoinColumn(name = "id_jugador", referencedColumnName = "id")
    private Jugador jugador;

    public Publicacion() {}

    public Publicacion(String titulo, String contenido, LocalDateTime fechaPublicacion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Publicacion(String titulo, String contenido, LocalDateTime fechaPublicacion, Jugador jugador) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
        this.jugador = jugador;
    }


    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }


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

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion publicacion = (Publicacion) o;
        return id.equals(publicacion.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}

