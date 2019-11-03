package com.example.springboot

import com.example.springboot.config.RetrofitConfig
import com.example.springboot.dto.PetDto
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.test.context.junit4.SpringRunner
import java.io.File

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PetStoreTest {

    @Autowired
    private lateinit var retrofitConfig: RetrofitConfig

    @Autowired
    private lateinit var objectMapper: ObjectMapper


    private var log = LoggerFactory.getLogger(PetStoreTest::class.java)


    @Test
    fun `Create Pet Store by Retrofit Config from json file`() {


        val dto = ClassPathResource("/src/main/kotlin/com/example/springboot/dto/dto.json").path
        val request = objectMapper.readValue<PetDto>(File(dto))

        val response = retrofitConfig.petStoreClientApi().postNewPetInStore(request).execute()
        log.info("This is response code - {} and posted pet - {}", response.code(), response.body().toString())
        Assertions.assertThat(response.code()).isEqualTo(200)
    }

    @Test
    fun `Verify created Pet in Store`() {


        val createdPet = retrofitConfig.petStoreClientApi().findPetByPetId("101").execute()
        log.info("This is response code - {} and retrieved pet - {}", createdPet.code(), createdPet.body().toString())
        Assertions.assertThat(createdPet.code()).isEqualTo(200)
    }

    @Test
    fun `Update Pet in Store`() {

        val json = """{
                          "id": 101,
                          "category": {
                            "id": 101,
                            "name": "kutta"
                          },
                          "name": "doggie101",
                          "photoUrls": [
                            "string"
                          ],
                          "tags": [
                            {
                              "id": 101,
                              "name": "kuttatag"
                            }
                          ],
                          "status": "sold"
                        }"""
        val updateRequest = objectMapper.readValue<PetDto>(json)
        val updatedPet = retrofitConfig.petStoreClientApi().updateExistingPetInStore(updateRequest).execute()
        log.info("This is response code - {} and updatedPet - {}", updatedPet.code(), updatedPet.body().toString())
        Assertions.assertThat(updatedPet.code()).isEqualTo(200)
    }

    @Test
    fun `Delete Pet in Store`() {
        val deletedPet = retrofitConfig.petStoreClientApi().deletePetFromStore("101").execute()
        log.info("This is response code - {} and deletedPet - {}", deletedPet.code(), deletedPet.body().toString())
        Assertions.assertThat(deletedPet.code()).isEqualTo(200)

        val checkPetAgain = retrofitConfig.petStoreClientApi().findPetByPetId("101").execute()
        log.info("This is response code - {} and not existed pet - {}", checkPetAgain.code(), checkPetAgain.body().toString())
        Assertions.assertThat(checkPetAgain.code()).isEqualTo(404)

    }
}
