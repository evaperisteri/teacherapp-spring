package gr.aueb.cf.teacherApp.service;

import gr.aueb.cf.teacherApp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacherApp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherApp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherApp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherApp.mapper.Mapper;
import gr.aueb.cf.teacherApp.model.Teacher;
import gr.aueb.cf.teacherApp.model.static_data.Region;
import gr.aueb.cf.teacherApp.repository.RegionRepository;
import gr.aueb.cf.teacherApp.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService implements ITeacherService{

    private final TeacherRepository teacherRepository;
    private final RegionRepository regionRepository;
    private final Mapper mapper;

//    @Autowired
//    public TeacherService(TeacherRepository teacherRepository, RegionRepository regionRepository, Mapper mapper) {
//        this.teacherRepository = teacherRepository;
//        this.regionRepository = regionRepository;
//        this.mapper = mapper;
//    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Teacher saveTeacher(TeacherInsertDTO dto) throws EntityAlreadyExistsException, EntityInvalidArgumentException {
        if(teacherRepository.findByVat(dto.getVat()).isPresent()){
            throw new EntityAlreadyExistsException("Teacher", "Teacher with vat " + dto.getVat() + " already exists");
        }
        Teacher teacher = mapper.mapToTeacherEntity(dto);
        Region region = regionRepository.findById(dto.getRegionId()).orElseThrow(()-> new EntityInvalidArgumentException("Region", "Invalid region id"));
        region.addTeacher(teacher);
        return teacherRepository.save(teacher);
    }

    @Override
    public Page<TeacherReadOnlyDTO> getPaginatedTeachers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Teacher> teacehrPage = teacherRepository.findAll(pageable);
        return teacehrPage.map(mapper::mapToTeacherReadOnlyDTO);
    }
}
