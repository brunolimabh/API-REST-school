package school.sptech.apirestschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.apirestschool.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
