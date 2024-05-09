package school.sptech.apirestschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.apirestschool.dto.student.StudentMapper;
import school.sptech.apirestschool.dto.student.StudentRequest;
import school.sptech.apirestschool.entity.Student;
import school.sptech.apirestschool.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Student create(StudentRequest request) {
        Student entity = StudentMapper.toEntity(request);
        return repository.save(entity);
    }

    public List<Student> list() {
        return repository.findAll();
    }

    public Student listById(int id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

}
