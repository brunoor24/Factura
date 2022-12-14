package com.example.Proyectsf.service

import com.example.Proyectsf.model.Product
import com.example.Proyectsf.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository
    fun save (product:Product):Product{
        return productRepository.save(product)
    }
    fun list (pageable: Pageable, product: Product): Page<Product> {
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("brand"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return productRepository.findAll(Example.of(product, matcher), pageable)

    }
    fun update(product:Product):Product{
        try {
        productRepository.findById(product.id)
            ?: throw Exception("ID no existe")
        return  productRepository.save(product)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateBrand(product:Product): Product {
        try{
            val response = productRepository.findById(product.id)
                ?: throw Exception("ID no existe")
            response.apply {
                brand=product.brand
            }
            return productRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}