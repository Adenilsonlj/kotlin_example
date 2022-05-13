package api.example.poc.adapter

import api.example.poc.business.repository.EmployerRepository
import api.example.poc.domain.Employer
import org.springframework.stereotype.Component

@Component
class GetAllEmployerUseCase(private val repository: EmployerRepository) {
    fun findAll() : List<Employer> {
        return repository.getAll()
    }
}