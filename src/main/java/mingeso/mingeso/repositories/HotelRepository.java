package mingeso.mingeso.repositories;

import mingeso.mingeso.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
