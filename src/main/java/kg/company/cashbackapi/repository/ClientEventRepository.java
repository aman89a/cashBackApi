package kg.company.cashbackapi.repository;

import kg.company.cashbackapi.entity.ClientEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEventRepository extends JpaRepository<ClientEvent, Long> {
}
