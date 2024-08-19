package com.example.estoque.controller;

import com.example.estoque.model.Produto;
import com.example.estoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping("/adicionar")
    public void adicionarProduto(@RequestParam String nome, @RequestParam int quantidade) {
        estoqueService.adicionarProduto(nome, quantidade);
    }

    @PostMapping("/remover")
    public void removerProduto(@RequestParam String nome, @RequestParam int quantidade) {
        estoqueService.removerProduto(nome, quantidade);
    }

    @GetMapping("/listar")
    public Map<String, Produto> listarProdutos() {
        return estoqueService.listarProdutos();
    }
}
