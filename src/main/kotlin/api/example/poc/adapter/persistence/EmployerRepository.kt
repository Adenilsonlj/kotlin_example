package api.example.poc.adapter.persistence

import api.example.poc.adapter.persistence.entity.EmployerEntity
import api.example.poc.adapter.persistence.repository.EmployerJPARepository
import api.example.poc.business.repository.EmployerRepository
import api.example.poc.domain.Employer
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class EmployerRepositoryImpl (private val repository: EmployerJPARepository): EmployerRepository {
    override fun get(id: Long): Employer? {
       return repository.findByIdOrNull(id)?.toDomain()
    }

    override fun getAll(): List<Employer> {
        return repository.findAll().map { it.toDomain() }
    }

    override fun put(id: Long, employer: Employer): Employer {
        return repository.save(EmployerEntity(id = id, name = employer.name)).toDomain()
    }

    override fun post(employer: Employer): Employer {
        return repository.save(EmployerEntity.fromDomain(employer)).toDomain()
    }

    override fun delete(id: Long): Boolean {
        repository.deleteById(id)
        return true
    }
}