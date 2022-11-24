package com.example.Proyectsf.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "client")

class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nui: String?=null
    @NotBlank
    var fullname: String?=null
    @NotBlank
    var address: String?=null
}