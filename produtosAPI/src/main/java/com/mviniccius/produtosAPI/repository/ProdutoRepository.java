package com.mviniccius.produtosAPI.repository;

import com.mviniccius.produtosAPI.model.Produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);

}
