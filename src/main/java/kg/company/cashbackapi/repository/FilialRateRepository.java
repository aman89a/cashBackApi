package kg.company.cashbackapi.repository;

import kg.company.cashbackapi.entity.FilialRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilialRateRepository extends JpaRepository<FilialRate, Long> {
}
