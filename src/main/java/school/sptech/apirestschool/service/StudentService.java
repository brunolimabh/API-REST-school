package school.sptech.apirestschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.apirestschool.constants.ControllerConstants;
import school.sptech.apirestschool.entity.Student;
import school.sptech.apirestschool.entity.Teacher;
import school.sptech.apirestschool.exception.NotFoundException;
import school.sptech.apirestschool.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final TeacherService teacherService;

    public Student create(Student entity, Integer professorId) {
        Teacher teacher = teacherService.listById(professorId);
        entity.setTeacher(teacher);
        return repository.save(entity);
    }

    public List<Student> list() {
        return repository.findAll();
    }

    public Student listById(int id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException(ControllerConstants.STUDENT_ENTITY));
    }

    public void remove(int id) {
        Student student = listById(id);
        repository.delete(student);
    }

}
