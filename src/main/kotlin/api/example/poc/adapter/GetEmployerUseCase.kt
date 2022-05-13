package api.example.poc.adapter

import api.example.poc.business.repository.EmployerRepository
import api.example.poc.domain.Employer
import org.springframework.stereotype.Component

@Component
class GetEmployerUseCase (private val repository: EmployerRepository) {
    fun find(id: Long) : Employer? {
        return repository.get(id)
    }
}