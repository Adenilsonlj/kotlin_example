package api.example.poc.adapter.endpoint

import api.example.poc.adapter.*
import api.example.poc.business.dto.EmployerDto
import api.example.poc.domain.Employer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employer")
class EmployerController (
    private val getAllEmployerUseCase: GetAllEmployerUseCase,
    private val getEmployerUseCase: GetEmployerUseCase,
    private val putEmployerUseCase: PutEmployerUseCase,
    private val postEmployerUseCase: PostEmployerUseCase,
    private val deleteEmployerUseCase: DeleteEmployerUseCase
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<EmployerDto>> {
        val employers = getAllEmployerUseCase.findAll().map  { it.toDto() }
        if (employers.isEmpty()) {
            ResponseEntity<List<EmployerDto>>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity<List<EmployerDto>>(employers, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<EmployerDto> {
        val employer = getEmployerUseCase.find(id)?.toDto()
        return ResponseEntity(employer, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun put(@PathVariable id: Long, @RequestBody body: EmployerDto): ResponseEntity<EmployerDto> {
        val response = putEmployerUseCase.put(id, body.toDomain())
        return ResponseEntity(response?.toDto(), HttpStatus.OK)
    }

    @PostMapping()
    fun post(@RequestBody body: EmployerDto): ResponseEntity<EmployerDto> {
        val employer = postEmployerUseCase.post(body.toDomain())
        return ResponseEntity(employer?.toDto(), HttpStatus.CREATED)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Boolean> {
        deleteEmployerUseCase.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }
}