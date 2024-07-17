package com.alura.challange.literalura.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.challange.literalura.client.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE :anio between a.fechaNacimiento AND a.fechaFallecimiento")
    List<Autor> findForYear(int anio);

}
