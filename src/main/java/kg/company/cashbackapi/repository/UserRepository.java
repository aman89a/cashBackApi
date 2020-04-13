package kg.company.cashbackapi.repository;

import kg.company.cashbackapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
