package example.day03._4과제.service;

import example.day03._4과제.model.dto.BoardDto;
import example.day03._4과제.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaordService {

    @Autowired private BoardMapper boardMapper;

    // 1. 글쓰기
    public boolean write(BoardDto boardDto){
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardMapper.write(boardDto);
        return result;
    } // f end

    // 2. 전체 글 조회
    public List<BoardDto> findAll(){
        System.out.println("BoardController.findAll");
        System.out.println();
        List<BoardDto> result = boardMapper.findAll();
        return result;
    } // f end

    // 3. 개별 글 조회
    public BoardDto find( int bno ){
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);
        BoardDto result = boardMapper.find(bno);
        return result;
    } // f end

    // 4. 개별 글 수정
    public boolean update(BoardDto boardDto){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardMapper.update(boardDto);
        return result;
    } // f end

    // 5. 개별 글 삭제
    public boolean delete( int bno ){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        boolean result = boardMapper.delete(bno);
        return result;
    }

}
