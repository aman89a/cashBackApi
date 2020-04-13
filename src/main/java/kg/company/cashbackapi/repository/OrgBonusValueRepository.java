package kg.company.cashbackapi.repository;

import kg.company.cashbackapi.entity.OrgBonusValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgBonusValueRepository extends JpaRepository<OrgBonusValue, Long> {
}
