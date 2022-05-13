package api.example.poc.adapter.persistence.repository

import api.example.poc.adapter.persistence.entity.EmployerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EmployerJPARepository: JpaRepository<EmployerEntity, Long> {
}