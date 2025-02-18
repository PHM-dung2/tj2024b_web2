package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day02/task2/board")
public class BoardController2 {

    private final BoardDao boardDao;

    @Autowired
    public BoardController2(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    // 1. 글쓰기
    @PostMapping
    public boolean write( @RequestBody BoardDto boardDto ){
        System.out.println("BoardController.write");
        boolean result = boardDao.write( boardDto );
        return result;
    } // f end

    // 2. 전체 글 쓰기
    @GetMapping
    public List<BoardDto> findAll( ){
        System.out.println("BoardController.findAll");
        List<BoardDto> result = boardDao.findAll();
        return result;
    } // f end

    // 3. 개별 글 조회
    @GetMapping("/view")
    public BoardDto findByBno(@RequestParam( name = "bno" ) int bno){
        System.out.println("BoardController.findByBno");
        BoardDto result = boardDao.findByBno( bno );
        return result;
    } // f end

    // 4. 개별 글 수정
    @PutMapping
    public boolean update( @RequestBody BoardDto boardDto ){
        System.out.println("BoardController.update");
        boolean result = boardDao.update( boardDto );
        return result;
    } // f end

    // 5. 개별 글 삭제
    @DeleteMapping
    public boolean delete( @RequestParam( name = "bno" ) int bno ){
        System.out.println("BoardController.delete");
        boolean result = boardDao.delete( bno );
        return result;
    } // f end

}
