package example.day03._4과제.controller;

import example.day03._4과제.model.dto.BoardDto;
import example.day03._4과제.service.BaordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/day03/task/board")
@RestController
public class BoardController {

    @Autowired
    private BaordService baordService;

    // 1. 글쓰기
    @PostMapping
    public boolean write(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);
        boolean result = baordService.write(boardDto);
        return result;
    } // f end

    // 2. 전체 글 조회
    @GetMapping
    public List<BoardDto> findAll(){
        System.out.println("BoardController.findAll");
        System.out.println();
        List<BoardDto> result = baordService.findAll();
        return result;
    } // f end

    // 3. 개별 글 조회
    @GetMapping("/view")
    public BoardDto find( @RequestParam( "bno" ) int bno ){
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);
        BoardDto result = baordService.find(bno);
        return result;
    } // f end

    // 4. 개별 글 수정
    @PutMapping
    public boolean update(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        boolean result = baordService.update(boardDto);
        return result;
    } // f end

    // 5. 개별 글 삭제
    @DeleteMapping
    public boolean delete(@RequestParam( "bno" ) int bno ){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        boolean result = baordService.delete(bno);
        return result;
    }

}
