package net.javaguids.bt1.controller;

import net.javaguids.bt1.dto.StudentDto;
import net.javaguids.bt1.entity.Student;
import net.javaguids.bt1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @GetMapping
    public  ResponseEntity<?> getStudent(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @PostMapping("/1")
    public ResponseEntity<?> save(@RequestBody StudentDto request) {
         new ResponseEntity<>(
                studentService.save(Student.builder()
                        .name(request.getName())
                        .age(request.getAge())
                        .build()),
                HttpStatus.CREATED);

         return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @PostMapping("/2/{name}/{age}")
    public ResponseEntity<?> save(@PathVariable String name, @PathVariable int age) {
        Student student = Student.builder()
                .name(name)
                .age(age)
                .build();
        studentService.save(student);
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @PostMapping("/3")
    public ResponseEntity<Student> createStudent(
            @RequestParam("name") String name,
            @RequestParam("age") int age) {

        Student student = Student.builder()
                .name(name)
                .age(age)
                .build();

        Student savedStudent = studentService.save(student);

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
}
