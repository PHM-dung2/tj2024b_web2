package example.day03._4과제.model.mapper;


import example.day03._4과제.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 1. 글쓰기
    boolean write(BoardDto boardDto);
    // 2. 전체 글 조회
    List<BoardDto> findAll();
    // 3. 개별 글 조회
    BoardDto find(int bno );
    // 4. 개별 글 수정
    boolean update( BoardDto boardDto );
    // 5. 개별 글 삭제
    boolean delete( int bno );

}
