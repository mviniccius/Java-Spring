package com.mviniccius.libaryapi.repository;

import com.mviniccius.libaryapi.model.Autor;
import com.mviniccius.libaryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    List<Livro> findByAutor(Autor autor);

}
