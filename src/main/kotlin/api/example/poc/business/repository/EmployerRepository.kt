package api.example.poc.business.repository

import api.example.poc.domain.Employer

interface EmployerRepository {
    fun get(id: Long): Employer?
    fun getAll(): List<Employer>
    fun put(id: Long, employer: Employer): Employer
    fun post(employer: Employer): Employer
    fun delete(id: Long): Boolean

}