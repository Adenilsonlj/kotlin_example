package api.example.poc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CompanyApplication

fun main(args: Array<String>) {
	runApplication<CompanyApplication>(*args)
}
