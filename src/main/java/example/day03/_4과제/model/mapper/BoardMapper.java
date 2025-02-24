package example.day03._4과제.model.mapper;


import example.day03._4과제.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    // + SQL 매핑하는 방법 : 1. XML

    // 1. 글쓰기
    // @Insert(" insert into board( title, content ) values( #{ titlt }, #{ content } ") // [4] 어노테이션 SQL 매핑
    boolean write(BoardDto boardDto); // [4] .xml 파일의 SQL 매핑( 복잡한 쿼리 관리 편리성 )
    // 2. 전체 글 조회
    // @Select(" select * from board ")
    List<BoardDto> findAll();
    // 3. 개별 글 조회
    // @Select(" select * from board where bno = #{ cno }")
    BoardDto find(int bno );
    // 4. 개별 글 수정
    // @Update(" update board set title = #{ title }, content = #{ content } where bno = #{ bno } ")
    boolean update( BoardDto boardDto );
    // 5. 개별 글 삭제
    // @Delete(" delete from board where bno = #{ bno } ")
    boolean delete( int bno );

}
