package example.day02._3과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/day02/task1/board")
public class BoardController {

    private final List<BoardDto> BoardList = new ArrayList<>();
    private int bno = 1;

    // 1. 글쓰기\
    @PostMapping
    public boolean write( @RequestBody BoardDto boardDto ){
        System.out.println("BoardController.write");
        boardDto.setBno( bno++ );
        BoardList.add( boardDto );
        System.out.println("boardDto = " + boardDto);
        return true;
    } // f end

    // 2. 전체 글 쓰기
    @GetMapping
    public List<BoardDto> findAll( ){
        System.out.println("BoardController.findAll");
        return BoardList;
    } // f end

    // 3. 개별 글 조회
    @GetMapping("/view")
    public BoardDto findByBno(@RequestParam( name = "bno" ) int bno){
        System.out.println("BoardController.findByBno");
        BoardDto result = new BoardDto();

        for( int i = 0 ; i < BoardList.size() ; i++){
            BoardDto boardDto = BoardList.get(i);
            if( boardDto.getBno() == bno ){ return result = boardDto; }
        } // for end
        return null;
    } // f end

    // 4. 개별 글 수정
    @PutMapping
    public boolean update( @RequestBody BoardDto boardDto ){
        System.out.println("BoardController.update");

        for( int i = 0 ; i < BoardList.size() ; i++){
            BoardDto board = BoardList.get(i);
            if( board.getBno() == boardDto.getBno() ){
                BoardList.set( i, boardDto); return true;
            } // if end
        } // for end
        return false;
    } // f end

    // 5. 개별 글 삭제
    @DeleteMapping
    public boolean delete( @RequestParam( name = "bno" ) int bno ){
        System.out.println("BoardController.delete");

        for( int i = 0 ; i < BoardList.size() ; i++){
            BoardDto board = BoardList.get(i);
            if( board.getBno() == bno ){ BoardList.remove(i); return true;  }
        } // for end
        return false;
    } // f end

}
