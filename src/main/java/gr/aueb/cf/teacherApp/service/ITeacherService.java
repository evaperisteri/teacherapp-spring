package gr.aueb.cf.teacherApp.service;

import gr.aueb.cf.teacherApp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacherApp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherApp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherApp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherApp.model.Teacher;
import org.springframework.data.domain.Page;

public interface ITeacherService {
    Teacher saveTeacher(TeacherInsertDTO dto) throws EntityAlreadyExistsException, EntityInvalidArgumentException;
    Page<TeacherReadOnlyDTO> getPaginatedTeachers(int page, int size);
}
