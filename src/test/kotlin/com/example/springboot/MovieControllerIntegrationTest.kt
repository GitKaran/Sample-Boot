package com.example.springboot

import com.example.springboot.config.RetrofitConfig
import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.restassured.RestAssured
import org.assertj.core.api.Assertions
import org.hamcrest.Matchers
import org.hamcrest.Matchers.hasEntry
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MovieControllerIntegrationTest {

    @Autowired
    private lateinit var retrofitConfig: RetrofitConfig

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Value("\${api.key}")
    private lateinit var apiKey: String


    private var log = LoggerFactory.getLogger(PetStoreTest::class.java)

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

    @Test
    fun `Get movie from movie client api`() {

        val getMovie = retrofitConfig.movieStoreClientApi().getMovieInfoByMovieId(3,100, apiKey).execute()
        log.info("This is response code - {} and retrieved movie - {}", getMovie.code(), getMovie.body().toString())
        Assertions.assertThat(getMovie.code()).isEqualTo(200)
    }
}
