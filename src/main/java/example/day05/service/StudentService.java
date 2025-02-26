package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // 빈 등록
public class StudentService {

    @Autowired private StudentMapper studentMapper;

    // 1. 등록
    public int save( HashMap<String, Object> map ){
        System.out.println("StudentController.save");
//        return studentMapper.save( map );
        System.out.println("========= SQL 처리 전 ==========");
        System.out.println("map = " + map);

        int result = studentMapper.save( map );
        System.out.println("========= SQL 처리 후 ==========");
        System.out.println("result = " + result); // soutv : 가장 가까운 변수 출력
        // result = 1 , sql 실행 결과 처리된 레코드 수
        System.out.println("map = " + map);
        // map = map = {sno=4, name=유재석, math=50, kor=40},
        // sql 처리하기 전 sno는 없었지만 sql 처리된 후 sno가 존재한다.

        return result;
    } // f end

    // 2. 전체조회
    public List< Map<String, Object> > findAll(){
        System.out.println("StudentController.findAll");
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
