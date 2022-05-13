package api.example.poc.domain

import api.example.poc.business.dto.EmployerDto

data class Employer(val id: Long, val name: String) {
    fun toDto() = EmployerDto(id, name)

    companion object{
        fun toDto(employer: Employer) = EmployerDto(employer.id, employer.name)
    }
}
