package com.mviniccius.produtosAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table //mapar qual tabela do banco de dados
public class Produto {

    @Id
    @Column (name ="id")//serve para mapear colunas no banco de dados
    private String id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private double preco;

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }
}
