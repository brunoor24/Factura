package com.example.Proyectsf.repository

import com.example.Proyectsf.model.Client
import com.example.Proyectsf.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long?> {
    fun findById(id: Long?): Product?
}
