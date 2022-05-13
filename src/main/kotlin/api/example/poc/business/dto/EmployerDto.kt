package api.example.poc.business.dto

import api.example.poc.domain.Employer
import com.fasterxml.jackson.annotation.JsonProperty

data class EmployerDto (@JsonProperty("id") var id: Long, @JsonProperty("name") var name: String) {
    fun toDomain() = Employer(id, name)

    companion object{
        fun fromDomain(employer: Employer) = EmployerDto(employer.id, employer.name)
    }
}