package example.day05.controller;

import example.day05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // HTTP 요청/응답 처리( +@ResponseBody 포함, 주로 JSON 반환 )
@RequestMapping("/day05/students") // HTTP 요청 URL 매핑( 주로 공통 URL 정의 )
public class StudentController {

    @Autowired private StudentService studentService;

    // 1. 등록
    @PostMapping
    public int save( @RequestBody HashMap<String, Object> map ){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        return studentService.save( map );
    } // f end

    // 2. 전체조회
    @GetMapping
    public List< Map<String, Object> > findAll(){
        System.out.println("StudentController.findAll");
        return studentService.findAll();
    } // f end

    // 3. 수정
    @PutMapping
    public int update( @RequestBody Map<String, Object> map ){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentService.update( map );
    } // f end

    // 4. 삭제
    @DeleteMapping
    public boolean delete( @RequestParam int sno ){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete( sno );
    } // f end

    // 5. 특점 점수 이상 학생 조회
    @GetMapping("/find/score")
    public List< Map<String, Object> > findStudentScore( @RequestParam int minKor, @RequestParam int minMath ){
        System.out.println("StudentController.findScoreOver");
        System.out.println("minKor = " + minKor + ", minMath = " + minMath);
        return studentService.findStudentScore( minKor, minMath );
    } // f end

    // 6. 여러명의 학생 등록하기
    @PostMapping("/save/all")
    public boolean saveAll( @RequestBody List< Map<String, Object> > list ){
        System.out.println("StudentController.saveAll");
        System.out.println("list = " + list);
        return studentService.saveAll( list );
    } // f end

    @GetMapping("/aaa")
    public boolean aaa( @RequestParam int a){
        System.out.println("a = " + a);
        return true;
    }

}
