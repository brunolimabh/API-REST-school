package school.sptech.apirestschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.apirestschool.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByTeacherId(int teacherId);
}
