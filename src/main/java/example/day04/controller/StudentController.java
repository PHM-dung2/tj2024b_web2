package example.day04.controller;

import example.day04.model.dto.StudentDto;
import example.day04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("day04/student")
public class StudentController {

    @Autowired private StudentService studentService;

    // 1. 학생 점수 등록
    @PostMapping
    public boolean write( @RequestBody StudentDto studentDto ){
        System.out.println("StudentController.write");
        System.out.println("studentDto = " + studentDto);
        return studentService.write(studentDto);
    } // f end

    // 2. 학생 전체 조회
    @GetMapping
    public List<StudentDto> findAll(){
        System.out.println("StudentController.findAll");
        return studentService.findAll();
    }

    // 3. 학생 개별 수정
    @PutMapping
    public boolean update( @RequestBody StudentDto studentDto ){
        System.out.println("StudentController.update");
        System.out.println("studentDto = " + studentDto);
        return studentService.update(studentDto);
    } // f end

    // 4. 학생 개별 삭제
    @DeleteMapping
    public boolean delete( @RequestParam( "sno" ) int sno ){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete(sno);
    }  // f end

}
