package api.example.poc.adapter

import api.example.poc.business.repository.EmployerRepository
import api.example.poc.domain.Employer
import org.springframework.stereotype.Component

@Component
class PutEmployerUseCase (private val repository: EmployerRepository) {
    fun put(id: Long, employer: Employer) : Employer? {
        return repository.put(id, employer)
    }
}