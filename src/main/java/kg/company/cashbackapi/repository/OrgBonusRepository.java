package kg.company.cashbackapi.repository;

import kg.company.cashbackapi.entity.OrgBonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgBonusRepository extends JpaRepository<OrgBonus, Long> {

}
