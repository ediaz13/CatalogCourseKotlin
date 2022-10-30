package com.kotlinspring.service

import org.springframework.stereotype.Service

@Service
class GreetingsService {

    fun retrieveGreting(name : String) = "Hello $name"
}