package kg.company.cashbackapi.repository;

import kg.company.cashbackapi.entity.OrgBonusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusTypeRepository extends JpaRepository<OrgBonusType, Long> {

}
