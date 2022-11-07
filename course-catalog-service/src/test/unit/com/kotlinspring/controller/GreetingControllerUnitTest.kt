package com.kotlinspring.controller

import com.kotlinspring.service.GreetingsService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient


@WebMvcTest(controllers = [GreetingController::class])
@AutoConfigureWebTestClient
class GreetingControllerUnitTest
{
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var greetingsServiceMock : GreetingsService

    @Test
    fun retrieveGreeting() {

        val name = "Emanuel"

        every { greetingsServiceMock.retrieveGreeting(any()) } returns "Hello $name, Hello from default profile"

        val result = webTestClient.get()
                .uri("/v1/greetings/{name}", name)
                .exchange()
                .expectStatus().is2xxSuccessful
                .expectBody(String::class.java)
                .returnResult()

        Assertions.assertEquals("Hello $name, Hello from default profile", result.responseBody)

    }
}