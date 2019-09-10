package mingeso.mingeso.repositories;

import mingeso.mingeso.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {
    List<Student> findAllByCareerCareerId(Long careerId);
}
