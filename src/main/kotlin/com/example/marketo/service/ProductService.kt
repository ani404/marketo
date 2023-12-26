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
        if (product.id != null || product.name != null || product.price != null) {
            return productRepository.save(product)
        } else {
            throw IllegalArgumentException("At least one field in the Product must not be null")
        }
    }

    fun deleteProductById(id: Int) {
        productRepository.deleteById(id)
    }
}
