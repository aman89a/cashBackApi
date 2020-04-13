package kg.company.cashbackapi.repository;

import kg.company.cashbackapi.entity.PreferenceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceCategoryRepository extends JpaRepository<PreferenceCategory, Long> {
}
