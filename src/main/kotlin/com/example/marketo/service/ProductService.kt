package com.example.marketo.service

import com.example.marketo.entities.Product
import com.example.marketo.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getAllProducts(): MutableIterable<Product> = productRepository.findAll()

    fun getProductById(id: Int): Optional<Product> = productRepository.findById(id)

    fun updateProduct(product: Product): Product = productRepository.save(product)

    fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    fun deleteProductById(id: Int) {
        productRepository.deleteById(id)
    }
}
