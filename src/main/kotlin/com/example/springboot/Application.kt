/*
* This class is the main class,
* This is just a standard method that follows the Java convention for an application entry point.
* main method delegates to Spring Boot’s SpringApplication class by calling run.
* SpringApplication bootstraps the application, starting Spring
*
*
* */

package com.example.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	SpringApplication.run(Application::class.java, *args)
}
