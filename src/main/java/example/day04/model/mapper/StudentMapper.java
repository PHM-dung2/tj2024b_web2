package example.day04.model.mapper;

import example.day04.model.dto.StudentDto;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface StudentMapper {

    // 방법1 : XML
    // 방법2 : @SQL

    // 1. 학생 점수 등록
    @Insert(" INSERT INTO students( name, kor, math ) VALUES( #{ name }, #{ kor }, #{ math } ) " )
    boolean write( StudentDto studentDto );

    // 2. 학생 전체 조회
    @Select(" SELECT * FROM students ")
    List<StudentDto> findAll();

    // 3. 학생 개별 수정
    @Update(" UPDATE students SET name = #{ name }, kor = #{ kor }, math = #{ math } where sno = #{ sno }")
    boolean update( StudentDto studentDto );

    // 4. 학생 개별 삭제
    @Delete(" DELETE FROM students WHERE sno = #{ sno } ")
    boolean delete( int sno );

}
