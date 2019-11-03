package com.example.springboot.config

import com.example.springboot.dto.PetDto
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PetStore {
    @GET("/v2/pet/findByStatus/{status}")
    fun findPetByStatus(
            @Path("status") status: String
    ): Call<ResponseBody>

    @GET("/v2/pet/{petId}")
    fun findPetByPetId(
            @Path("petId") petId: String
    ): Call<PetDto>

    @POST("/v2/pet")
    fun postNewPetInStore(
            @Body petDto: PetDto
    ): Call<PetDto>

    @PUT("/v2/pet")
    fun updateExistingPetInStore(
            @Body petDto: PetDto
    ): Call<PetDto>

    @DELETE("/v2/pet/{id}")
    fun deletePetFromStore(
            @Path("id") id: String
    ): Call<Void>
}

/*interface PetStoreClientApi {
    // factory methods
    companion object {
        fun create(baseUrl: String): PetStore {

            val mapper = ObjectMapper()
                    .registerKotlinModule()

            val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(JacksonConverterFactory.create(mapper))
                    .build()

            return retrofit.create(PetStore::class.java)
        }
    }

}*/

