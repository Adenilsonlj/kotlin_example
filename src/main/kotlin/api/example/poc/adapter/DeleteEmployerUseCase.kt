package api.example.poc.adapter

import api.example.poc.business.repository.EmployerRepository
import api.example.poc.domain.Employer
import org.springframework.stereotype.Component

@Component
class DeleteEmployerUseCase (private val repository: EmployerRepository) {
    fun delete(id: Long) : Boolean {
        repository.delete(id)
        return true;
    }
}