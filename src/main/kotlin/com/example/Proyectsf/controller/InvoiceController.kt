package com.example.Proyectsf.controller


import com.example.Proyectsf.model.Invoice
import com.example.Proyectsf.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService
    @PostMapping
    fun save (@RequestBody invoice:Invoice):Invoice{
        return invoiceService.save(invoice)
    }
    @GetMapping
    fun list ():List<Invoice>{
        return invoiceService.list()

    }
    @PutMapping
    fun update (@RequestBody invoice: Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }

    @PatchMapping
    fun updateTotal (@RequestBody invoice: Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.updateTotal(invoice), HttpStatus.OK)
    }
    @GetMapping("/totals/{total}")
    fun listTotals (@PathVariable("total") total: Double ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.listTotalMoreThan(total), HttpStatus.OK)
    }
}