package com.example.springboot

import com.jayway.restassured.RestAssured
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RatingControllerIntegrationTest {

    @Test
    fun `Should return 200, movie ids and respective ratings for a given userId`() {
        val userId = 501
        RestAssured.given().log().all()
                .contentType("application/json")
                .get("http://localhost:9095/ratings/$userId")
                .then().log().body()
                .statusCode(200)
                .content("userRating.movieId", Matchers.contains(101,102))
                .content("userRating.rating", Matchers.contains(11,12))
                .content("userId", Matchers.equalTo(userId))
    }

    @Test
    fun `Should return 400 when userId is not given in URI`() {
        RestAssured.given().log().all()
                .contentType("application/json")
                .get("http://localhost:9095/ratings/")
                .then().log().body()
                .statusCode(404)
                .content("$", Matchers.hasEntry("error", "Not Found"))
    }

    @Test
    fun `Should return 200, rating for a given movieId`() {
        val movieId = 103
        RestAssured.given().log().all()
                .contentType("application/json")
                .get("http://localhost:9095/ratings/movies/$movieId")
                .then().log().body()
                .statusCode(200)
                .content("movieId", Matchers.comparesEqualTo(movieId))
                .content("rating", Matchers.comparesEqualTo(13))
    }

    @Test
    fun `Should return 404, when movieId not found`() {
        val movieId = 1
        RestAssured.given().log().all()
                .contentType("application/json")
                .get("http://localhost:9095/ratings/movies/$movieId")
                .then().log().body()
                .statusCode(404)
                .content("title", Matchers.comparesEqualTo("Movie not available"))
                .content("message", Matchers.comparesEqualTo("Movie not available"))
    }
}
