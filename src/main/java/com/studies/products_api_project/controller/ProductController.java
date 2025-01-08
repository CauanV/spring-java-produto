/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studies.products_api_project.controller;

import java.util.ArrayList;
import java.util.List;
import com.studies.products_api_project.model.*;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador (Controller)
 * Aqui você manipula as requisições HTTP (GET, POST, DELETE, etc.).
 * 
 * @author Cauan
 */

@RestController // ela define uma classe que irá gerenciar as requisições HTTP e retornar
                // respostas diretamente no corpo
// da resposta (em vez de retornar uma view como no caso de páginas HTML
@RequestMapping("/products")
public class ProductController {

    private List<Product> product_List = new ArrayList<>();

    // endpoint to list product
    @GetMapping
    public List<Product> getAllProducts() {
        return product_List;
    }

    // endpoint to add product
    @PostMapping // POST é utilizado para enviar dados para o servidor, como quando você preenche
                 // um formulário e envia
    public Product addProduct(@RequestBody Product product) {
        this.product_List.add(product);
        return product;
    }

    // endpoint search produtc by Id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return product_List.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null); // realiza uma busca na lista product_List para encontrar o primeiro produto
                               // cujo id seja igual ao valor de id fornecido
    }

    // Endpoint para remover um produto por ID
    @DeleteMapping("/{id}")
    public String removeById(@PathVariable Long id) {
        product_List.removeIf(product -> product.getId() == id);
        return "Produto removido com sucesso";
    }

}
