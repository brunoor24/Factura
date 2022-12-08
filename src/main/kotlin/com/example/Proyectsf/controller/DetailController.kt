package com.example.Proyectsf.controller


import com.example.Proyectsf.model.Detail
import com.example.Proyectsf.service.DetailService


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/detail")
class DetailController {
    @Autowired
    lateinit var detailService: DetailService
    @PostMapping
    fun save (@RequestBody detail:Detail):Detail{
        return detailService.save(detail)
    }
    @GetMapping
    fun list ():List<Detail>{
        return detailService.list()
    }
    @PutMapping
    fun update (@RequestBody detail: Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.update(detail), HttpStatus.OK)
    }

    @PatchMapping
    fun updateQuantity (@RequestBody detail: Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.updateName(detail), HttpStatus.OK)
    }
}