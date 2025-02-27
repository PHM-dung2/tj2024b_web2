package example.day06.aop과제.service;

import example.day06.aop과제.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // 빈 등록
public class StudentService {

    @Autowired private StudentMapper studentMapper;

    // 1. 등록
    public int save( HashMap<String, Object> map ){
        return studentMapper.save( map );
    } // f end

    // 2. 전체조회
    public List< Map<String, Object> > findAll(){
        return studentMapper.findAll();
    } // f end

    // 3. 수정
    public int update( Map<String, Object> map ){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentMapper.update( map );
    } // f end

    // 4. 삭제
    public boolean delete( int sno ){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentMapper.delete( sno );
    } // f end

    // 5. 특정 점수 이상 학생 조회
    public List< Map<String, Object> > findStudentScore( int minKor, int minMath ){
        System.out.println("StudentController.findScoreOver");
        System.out.println("minKor = " + minKor + ", minMath = " + minMath);
        return studentMapper.findStudentScore( minKor, minMath );
    } // f end

    // 6. 여러명의 학생 등록하기
    public boolean saveAll( List< Map<String, Object> > list ){
        System.out.println("StudentController.saveAll");
        System.out.println("list = " + list);
        return studentMapper.saveAll( list );
    } // f end

}
