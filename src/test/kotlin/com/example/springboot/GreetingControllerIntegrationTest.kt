package com.example.springboot

import com.jayway.restassured.RestAssured
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class GreetingControllerIntegrationTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    /* Controller Integration Test using TestRestTemplate */
    @Test
    fun `GET when given name is Karan then returns "Hello, Karan"`() {

        // Given
        val name = "Karan"
        // When
        val body = restTemplate.getForObject("/hello/{name}", String::class.java, name)
        // Then
        assertThat(body).isEqualTo("Hello, $name")

    }

    /* Controller Integration Test using Rest Assured */

    @Before
    fun `setup`() {
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = 9095
    }

    @Test
    fun `When name given as Karan return "Hello Karan"`() {
        val name = "Karan"
        RestAssured.given().log().all()
                .contentType("application/json")
                .get("hello/${name}")
                .then().log().all()
                .statusCode(200)
                .body(containsString("Hello, Karan"))
    }

}
