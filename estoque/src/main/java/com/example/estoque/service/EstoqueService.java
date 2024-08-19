package com.example.estoque.service;

import com.example.estoque.model.Produto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EstoqueService {
    private final Map<String, Produto> estoque = new HashMap<>();

    public void adicionarProduto(String nome, int quantidade) {
        Produto produto = estoque.get(nome);
        if (produto == null) {
            estoque.put(nome, new Produto(nome, quantidade));
        } else {
            produto.setQuantidade(produto.getQuantidade() + quantidade);
        }
    }

    public void removerProduto(String nome, int quantidade) {
        Produto produto = estoque.get(nome);
        if (produto != null && produto.getQuantidade() >= quantidade) {
            produto.setQuantidade(produto.getQuantidade() - quantidade);
            if (produto.getQuantidade() == 0) {
                estoque.remove(nome);
            }
        }
    }

    public Map<String, Produto> listarProdutos() {
        return new HashMap<>(estoque);
    }
}
