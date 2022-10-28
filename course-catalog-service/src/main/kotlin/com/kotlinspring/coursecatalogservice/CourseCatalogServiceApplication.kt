package com.kotlinspring.coursecatalogservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CourseCatalogServiceApplication

fun main(args: Array<String>) {
	runApplication<CourseCatalogServiceApplication>(*args)
}
