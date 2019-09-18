package mingeso.mingeso.repositories;

import mingeso.mingeso.models.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career,Long> {
    Career findCareerByCareerId(Long id);
    Career findCareerByName(String name);
}

