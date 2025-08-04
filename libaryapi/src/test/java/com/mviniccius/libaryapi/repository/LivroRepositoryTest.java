package com.mviniccius.libaryapi.repository;

import com.mviniccius.libaryapi.model.Autor;
import com.mviniccius.libaryapi.model.GeneroLivro;
import com.mviniccius.libaryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTest(){
        Livro livro = new Livro();
        livro.setIsbn("98080-9090");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980, 6, 7));

        Autor autor = autorRepository.findById(UUID.fromString("1f7e3b8a-9cd1-4788-afae-78d6fc32d342")).orElse(null);
        livro.setAutor(autor);

        repository.save(livro);

    }

}