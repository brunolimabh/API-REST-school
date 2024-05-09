package school.sptech.apirestschool.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.apirestschool.constants.ControllerConstants;
import school.sptech.apirestschool.dto.student.StudentMapper;
import school.sptech.apirestschool.dto.student.StudentRequest;
import school.sptech.apirestschool.dto.student.StudentResponse;
import school.sptech.apirestschool.entity.Student;
import school.sptech.apirestschool.service.StudentService;

import java.util.List;

@RestController
@RequestMapping(ControllerConstants.STUDENT_BASE_PATH)
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public ResponseEntity<StudentResponse> create(
            @Valid @RequestBody StudentRequest request) {
        return ResponseEntity.created(null).body(StudentMapper.toDto(
                service.create(StudentMapper.toEntity(request), request.getProfessorId())));
    }

    @GetMapping()
    public ResponseEntity<List<StudentResponse>> list() {
        List<Student> students = service.list();
        if (students.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(StudentMapper.toDto(students));
    }

    @GetMapping(ControllerConstants.ID_PATH)
    public ResponseEntity<StudentResponse> listById(
            @PathVariable Integer id) {
        return ResponseEntity.ok(StudentMapper.toDto(service.listById(id)));
    }

    @DeleteMapping(ControllerConstants.ID_PATH)
    public ResponseEntity<Void> remove(
            @PathVariable int id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

}
