package com.example.springboot

import com.jayway.restassured.RestAssured
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CatalogControllerIntegrationTest {

    @Test
    fun `Should return 200 and retrieve movie name, description and rating for given userId`() {
        val userId = 501
        RestAssured.given().log().all()
                .contentType("application/json")
                .get("http://localhost:9095/catalog/$userId")
                .then().log().body()
                .statusCode(200)
                .content("movieId", Matchers.contains(101,102))
                .content("rating", Matchers.contains(11,12))
                .content("name", Matchers.notNullValue())
                .content("desc", Matchers.notNullValue())
    }

    @Test
    fun `Should return 404 when userId is not given`() {
        RestAssured.given().log().all()
                .contentType("application/json")
                .get("http://localhost:9095/catalog/")
                .then().log().body()
                .statusCode(404)
                .content("$", Matchers.hasEntry("error", "Not Found"))
    }
}
