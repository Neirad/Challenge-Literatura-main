package com.alura.challange.literalura.client.model;

import com.alura.challange.literalura.client.util.CadenasUtil;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String lenguaje;
    private Integer descargas;
    @OneToOne(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;

    public Libro() {

    }

    public Libro(DatosLibro libro) {
        this.titulo = CadenasUtil.limitarLongitud(libro.title(), 200);
        this.descargas = libro.download();
        if (!libro.languages().isEmpty())
            this.lenguaje = libro.languages().get(0);
        if (!libro.autores().isEmpty()) {
            for (DatosAutor autor : libro.autores()) {
                this.autor = new Autor(autor);
                break;
            }
        }

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

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", lenguaje=" + lenguaje + ", descargas=" + descargas
                + ", autores=" + autor + "]";
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
