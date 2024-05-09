package school.sptech.apirestschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.apirestschool.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
