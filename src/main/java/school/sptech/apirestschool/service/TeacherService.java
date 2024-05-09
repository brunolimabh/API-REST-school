package school.sptech.apirestschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.apirestschool.constants.ControllerConstants;
import school.sptech.apirestschool.entity.Student;
import school.sptech.apirestschool.entity.Teacher;
import school.sptech.apirestschool.exception.NotFoundException;
import school.sptech.apirestschool.exception.RemoveTeacherWithStudentException;
import school.sptech.apirestschool.repository.StudentRepository;
import school.sptech.apirestschool.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;
    private final StudentRepository studentRepository;

    public Teacher create(Teacher entity) {
        return repository.save(entity);
    }

    public List<Teacher> list() {
        return repository.findAll();
    }

    public Teacher listById(int id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException(ControllerConstants.TEACHER_ENTITY));
    }

    public void remove(int id) {
        Teacher teacher = listById(id);
        List<Student> students = studentRepository.findByTeacherId(id);
        if (!students.isEmpty()) throw new RemoveTeacherWithStudentException();
        repository.delete(teacher);
    }

}
