package com.example.marketo.controller

import com.example.marketo.entities.Product
import com.example.marketo.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val productRepository: ProductRepository) {

    // @GetMapping("/")
    @GetMapping("/")
    fun home(): String = "Simple But cute home page"

    // @GetMapping("/products")
    @GetMapping("/products")
    fun getProducts(): MutableIterable<Product> = productRepository.findAll()

    // @GetMapping("/products/{id}")
    @GetMapping("/products/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<Product> {
        val product = productRepository.findById(id)
        return product.map { ResponseEntity.ok(it) }.orElse(ResponseEntity.notFound().build())
    }

    //@putMapping("/products/{id}")
    @PutMapping("/products/{id}")
    fun updateProductById(@PathVariable id: Long, @RequestBody updatedProduct: Product): ResponseEntity<Product> {
        return if (productRepository.existsById(id)) {
            updatedProduct.id = id // Assuming 'id' is a field in the Product class
            val savedProduct = productRepository.save(updatedProduct)
            ResponseEntity.ok(savedProduct)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // @PostMapping("/products")
    @PostMapping("/products")
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> {
        val createdProduct = productRepository.save(product)
        return ResponseEntity(createdProduct, HttpStatus.CREATED)
    }

}