package com.example.marketo

import com.example.marketo.entities.Product
import com.example.marketo.repository.ProductRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductConfiguration {

	@Bean
	fun databaseInitializer(productRepository: ProductRepository) = ApplicationRunner {
		productRepository.save(Product(name = "Face Cream", price = 100.0, quantity = 10))
		productRepository.save(Product(name = "Smart Phone", price = 2000.0, quantity = 4))
	}
}
