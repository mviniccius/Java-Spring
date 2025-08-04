package com.mviniccius.libaryapi.repository;

import com.mviniccius.libaryapi.model.Autor;
import com.mviniccius.libaryapi.model.GeneroLivro;
import com.mviniccius.libaryapi.model.Livro;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTeste(){
        Autor autor = new Autor();
        autor.setNome("Paula");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1966, 6, 9));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo: " + autorSalvo);
    }
    @Test
    void salvarAutorComLivrosTest(){
        Autor autor = new Autor();
        autor.setNome("Charlin");
        autor.setNacionalidade("Cubano");
        autor.setDataNascimento(LocalDate.of(1985,12,24));

        Livro livro = new Livro();
        livro.setIsbn("98080-3850");
        livro.setPreco(BigDecimal.valueOf(500));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("P.S Eu Te Amo");
        livro.setDataPublicacao(LocalDate.of(2003, 2, 28));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("99090-9595");
        livro2.setPreco(BigDecimal.valueOf(500));
        livro2.setGenero(GeneroLivro.ROMANCE);
        livro2.setTitulo("Senhora");
        livro2.setDataPublicacao(LocalDate.of(1874, 10, 12));
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);


        livroRepository.saveAll(autor.getLivros());
    }

    @Test

    void listarLivrosAutor(){
        var id = UUID.fromString("805ff795-8427-4af0-b626-8e8fb5ddb14e");
        var autor = repository.findById(id).get();

        List<Livro> livroLista = livroRepository.findByAutor(autor);

        autor.setLivros(livroLista);

        autor.getLivros().forEach(System.out::println);
    }

}
