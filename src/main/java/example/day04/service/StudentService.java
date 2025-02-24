package example.day04.service;

import example.day04.model.dto.StudentDto;
import example.day04.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {

    @Autowired private StudentMapper studentMapper;

    // 1. 학생 점수 등록
    public boolean write( StudentDto studentDto ) {
        System.out.println("StudentService.write");
        System.out.println("studentDto = " + studentDto);
        return studentMapper.write( studentDto );
    } // f end

    // 2. 학생 전체 조회
    public List<StudentDto> findAll(){
        System.out.println("StudentController.findAll");
        return studentMapper.findAll();
    }

    // 3. 학생 개별 수정
    public boolean update( @RequestBody StudentDto studentDto ){
        System.out.println("StudentController.update");
        System.out.println("studentDto = " + studentDto);
        return studentMapper.update(studentDto);
    } // f end

    // 4. 학생 개별 삭제
    public boolean delete( @RequestParam( "sno" ) int sno ){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentMapper.delete(sno);
    }  // f end

}
