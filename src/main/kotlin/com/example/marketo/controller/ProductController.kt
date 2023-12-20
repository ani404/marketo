package com.example.marketo.controller

import com.example.marketo.entities.Product
import com.example.marketo.repository.ProductRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val productRepository: ProductRepository) {

    @GetMapping("/products")
    fun getProducts(): MutableIterable<Product> = productRepository.findAll()


}