package com.example.springboot

import com.jayway.restassured.RestAssured
import org.hamcrest.Matchers
import org.hamcrest.Matchers.hasEntry
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MovieControllerIntegrationTest {

    @Test
    fun `Should return 200 and movie info for valid movie id`() {
        val movieId = 100
        RestAssured.given().log().all()
                .contentType("application/json")
                .get("http://localhost:9095/movies/$movieId")
                .then().log().body()
                .statusCode(200)
                .content("name", Matchers.notNullValue())
                .content("description", Matchers.notNullValue())
                .content("movieId", Matchers.equalTo(movieId))
    }

    @Test
    fun `Should return 500 and when movie is not present`() {
        val movieId = 1
        RestAssured.given().log().all()
                .contentType("application/json")
                .get("http://localhost:9095/movies/$movieId")
                .then().log().body()
                .statusCode(500)
                .content("$",  hasEntry("message", "404 Not Found"))
    }

    @Test
    fun `Should return 404 and when movieId is not given`() {

        RestAssured.given().log().all()
                .contentType("application/json")
                .get("http://localhost:9095/movies/")
                .then().log().body()
                .statusCode(404)
                .content("$",  hasEntry("error", "Not Found"))
    }
}
