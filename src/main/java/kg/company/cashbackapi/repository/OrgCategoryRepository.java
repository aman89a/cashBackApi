package kg.company.cashbackapi.repository;

import kg.company.cashbackapi.entity.OrgCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgCategoryRepository extends JpaRepository<OrgCategory, Long> {

}
