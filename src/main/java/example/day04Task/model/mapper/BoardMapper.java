package example.day04Task.model.mapper;

import example.day04Task.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 1. 글쓰기
    @Insert( "INSERT INTO board( title, content ) VALUES( #{ title }, #{ content } ) " )
    boolean write(BoardDto boardDto);
    // 2. 전체 글 조회
    @Select( "SELECT * FROM board" )
    List<BoardDto> findAll();
    // 3. 개별 글 조회
    @Select( "SELECT * FROM board where bno = #{ bno }" )
    BoardDto find(int bno);
    // 4. 개별 글 수정
    @Update( "UPDATE board SET title = #{ title } , content = #{ content } where bno = #{ bno }" )
    boolean update(BoardDto boardDto);
    // 5. 개별 글 삭제
    @Delete( "DELETE FROM board where bno = #{ bno }" )
    boolean delete(int bno);

}
