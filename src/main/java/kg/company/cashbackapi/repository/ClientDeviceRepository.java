package kg.company.cashbackapi.repository;

import kg.company.cashbackapi.entity.ClientDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDeviceRepository extends JpaRepository<ClientDevice, Long> {
}
