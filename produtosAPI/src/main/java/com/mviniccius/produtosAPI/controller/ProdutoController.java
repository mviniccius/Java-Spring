package com.mviniccius.produtosAPI.controller;

import com.mviniccius.produtosAPI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mviniccius.produtosAPI.model.Produto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido com sucesso: " +  produto.getNome());
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }
    @GetMapping("/{id}")
    public Produto obterProdutoId(@PathVariable("id") String id){
        System.out.println("Produto encontrato");
        return produtoRepository.findById(id).orElse( null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizarProduto(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
       return produtoRepository.findByNome(nome);
    }

}
