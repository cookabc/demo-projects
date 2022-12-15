package com.chuangcius.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @RequestMapping("/")
    fun helloWorld() = "Hello from Spring Boot"

    @GetMapping("/home")
    fun jetBrains() = "Hello from JetBrains"

    @GetMapping("/staff")
    fun getStaff(): Staff {
        return Staff(1, "John", "Stockton")
    }
}