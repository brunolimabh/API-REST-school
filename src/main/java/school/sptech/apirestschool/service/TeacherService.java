package school.sptech.apirestschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.apirestschool.dto.teacher.TeacherMapper;
import school.sptech.apirestschool.dto.teacher.TeacherRequest;
import school.sptech.apirestschool.entity.Student;
import school.sptech.apirestschool.entity.Teacher;
import school.sptech.apirestschool.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;

    public Teacher create(TeacherRequest request) {
        Teacher entity = TeacherMapper.toEntity(request);
        return repository.save(entity);
    }

    public List<Teacher> list() {
        return repository.findAll();
    }

    public Teacher listById(int id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aluno não encontrado")
        );
    }

}
