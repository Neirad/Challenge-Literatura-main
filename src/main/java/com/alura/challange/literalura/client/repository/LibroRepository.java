package com.alura.challange.literalura.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.challange.literalura.client.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.lenguaje >= :idioma")
    List<Libro> findForLanguaje(String idioma);

}
