package kg.company.cashbackapi.repository;


import kg.company.cashbackapi.entity.ClientPreferenceValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPreferenceValueRepository extends JpaRepository<ClientPreferenceValue, Long> {
}
