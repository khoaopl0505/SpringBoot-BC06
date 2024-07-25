package net.javaguids.bt1.service;

import net.javaguids.bt1.dto.StudentDto;

import net.javaguids.bt1.entity.Student;
import net.javaguids.bt1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudent() {
        List<StudentDto> studentDtos = new ArrayList<>();
        List<Student> students = studentRepository.findAll();

        for(Student data: students ){
            StudentDto studentDto = new StudentDto();
            studentDto.setName(data.getName());
            studentDto.setAge(data.getAge());

            studentDtos.add(studentDto);
        }


        return studentDtos;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
