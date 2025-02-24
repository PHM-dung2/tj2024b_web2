package example.day04Task.controller;

import example.day04Task.model.dto.BoardDto;
import example.day04Task.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/task/board")
public class BoardController {

    @Autowired private BoardService boardService;

    // 1. 글쓰기
    @PostMapping
    public boolean write(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);
        return boardService.write(boardDto);
    }

    // 2. 전체 글 조회
    @GetMapping
    public List<BoardDto> findAll(){
        System.out.println("BoardController.findAll");
        return boardService.findAll();
    }
    // 3. 개별 글 조회
    @GetMapping("/view")
    public BoardDto find(@RequestParam("bno") int bno){
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);
        return boardService.find(bno);
    }
    // 4. 개별 글 수정
    @PutMapping
    public boolean update(@RequestParam("bno") int bno, @RequestBody BoardDto boardDto){
        boardDto.setBno(bno);
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        return boardService.update(boardDto);
    }
    // 5. 개별 글 삭제
    @DeleteMapping
    public boolean delete(@RequestParam("bno") int bno){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        return boardService.delete(bno);
    }
}
