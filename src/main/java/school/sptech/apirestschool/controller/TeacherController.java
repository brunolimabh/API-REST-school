package school.sptech.apirestschool.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.apirestschool.constants.ControllerConstants;
import school.sptech.apirestschool.dto.teacher.TeacherMapper;
import school.sptech.apirestschool.dto.teacher.TeacherRequest;
import school.sptech.apirestschool.dto.teacher.TeacherResponse;
import school.sptech.apirestschool.entity.Teacher;
import school.sptech.apirestschool.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping(ControllerConstants.TEACHER_BASE_PATH)
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @PostMapping
    public ResponseEntity<TeacherResponse> create(
            @Valid @RequestBody TeacherRequest request) {
        return ResponseEntity.created(null).body(TeacherMapper.toDto(
                service.create(TeacherMapper.toEntity(request))));
    }

    @GetMapping()
    public ResponseEntity<List<TeacherResponse>> list() {
        List<Teacher> teachers = service.list();
        if (teachers.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(TeacherMapper.toDto(teachers));
    }

    @GetMapping(ControllerConstants.ID_PATH)
    public ResponseEntity<TeacherResponse> listById(
            @PathVariable Integer id) {
        return ResponseEntity.ok(TeacherMapper.toDto(service.listById(id)));
    }

    @DeleteMapping(ControllerConstants.ID_PATH)
    public ResponseEntity<Void> remove(
            @PathVariable int id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

}
