package api.example.poc.adapter.persistence.entity
import api.example.poc.domain.Employer
import javax.persistence.*

@Entity
@Table(name = "Employer")
data class EmployerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false)
    var name: String
)
{
    fun toDomain() = Employer(id, name)

    companion object {
        fun fromDomain(employer: Employer) = EmployerEntity(employer.id, employer.name)
    }
}