package mingeso.mingeso.repositories;

import mingeso.mingeso.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
