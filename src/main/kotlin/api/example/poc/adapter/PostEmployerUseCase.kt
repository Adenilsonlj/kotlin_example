package api.example.poc.adapter

import api.example.poc.business.repository.EmployerRepository
import api.example.poc.domain.Employer
import org.springframework.stereotype.Component

@Component
class PostEmployerUseCase (private val repository: EmployerRepository) {
    fun post(employer: Employer) : Employer? {
        return repository.post(employer)
    }
}