package example.day06.aop과제.model.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    // 인터페이스랑? 공통된 메소드들을 추상화해서 각 사용할 클래스에서 구체화(재정의)한다.
    // -> 리모콤/키보드같은 존재이다.
    // 추상메소드란? 메소드의 { 구현부 }를 빼고 선언부만 존재하는
    // -> 여러 곳에서 사용할 메소드를 반환타입, 매개변수, 함수명만 정의하고 각 사용처에서 구현한다.

    // 1. 등록
    @Insert( "INSERT INTO student( name, kor, math ) value( #{name}, #{kor}, #{math} )" )
    @Options( useGeneratedKeys = true, keyProperty = "sno" )
    int save( Map<String, Object> map );
    // 2. 전체 조회
    // @Select( "SELECT * FROM student" ) : native 쿼리 : 순수한 SQL 작성
    @Select( "<script> select * from student </script>" ) // 동적 쿼리 제공 : 순수한 SQL에 mybatis 추가적인 쿼리 제공 // XML형식
    List< Map<String, Object> > findAll();

    // 3. 수정
    @Update( "UPDATE student SET kor = #{kor}, math = #{math} WHERE sno = #{sno}" )
    int update( Map<String, Object> map );
    // 4. 삭제
    @Delete( "DELETE FROM student WHERE sno = #{sno}" )
    boolean delete( int sno );

    // [5] // [*] 특정한 점수 이상의 학생 조회( 동적 쿼리 표현 = <script> , <if>)
    // @Select( "SELECT * FROM student WHERE kor >=80")
    @Select("""
            <script>
                select * from student
                where 1=1
                <if test = "minKor != null">
                    and kor >= #{ minKor }
                </if>
                <if test = "minMath != null" >
                    and math >= #{ minMath }
                </if>
            </script>
            """) // java15 이상부터는(강의는 17) """ """ 템플릿 지원 : 문자열 입력할 떄 다음줄로 이어지는 방법
    List< Map<String, Object> > findStudentScore( int minKor, int minMath );
        // 해결 방법: """ 다음에 줄바꿈을 해야 함!
        // Java에서는 텍스트 블록을 사용할 때 시작 """ 바로 뒤에 문자열이 오면 오류가 발생합니다.
        // 그래서 <script>를 다음 줄에서 시작해야 합니다.
                // minKor이 null일때 실제 sql 표현 : select * from student where 1=1
                // minKor이 80일 때 실제 sql 표현 : select * from student where 1=1 and kor >= 80
                // minKor이 80이고 minMath가 90일 때 :  select * from student where 1=1 and minKor >= 80 and minMath >= 90
                // minKor이 null이고 minMath 70일 때 : select * from student where 1=1 and minMath >= 70


        // sql에서 1=1( true 뜻, 강제로 true 필요할 떄 방법 ) : 주로 다음 조건을 동적으로 처리할 때 사용된다.

    /*
        [기본] String text = "안녕하세요"
                             +" 유재석입니다";
        [java15 이상] String text = """
                                    안녕하세요
                                     유재석입니다.
                                    """;
    */

    // 6. 여러명의 학생 등록하기 , 추상메소드는 { }가 없다, 동적쿼리 = sql문법이 아닌 mybatis 자체 문법 제공
    // 동적쿼리 : <foreach collection="반복할리스트매개변수명" item="반복변수명" separator="반복사이문자"> </foreach>
    @Insert("""
            <script>
            INSERT INTO student( name, kor, math ) VALUES
            <foreach collection="list" item="student" separator=","> 
                ( #{ student.name }, #{ student.kor }, #{ student.math } )
            </foreach>
            </script>
            """ )
    boolean saveAll(List<Map<String, Object>> list);

}
