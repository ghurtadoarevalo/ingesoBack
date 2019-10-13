package mingeso.mingeso.repositories;

import mingeso.mingeso.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByPassport(String passport);
    Client findByClientId(Long id);
}
