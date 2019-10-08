package mingeso.mingeso.repositories;

import mingeso.mingeso.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
