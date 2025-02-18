package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardDao {

    private final List<BoardDto> BoardList = new ArrayList<>();
    private int bno = 1;

    // 1. 글쓰기
    public Boolean write( BoardDto boardDto ){
        System.out.println("BoardDao.wrtie");
        boardDto.setBno( bno++ );
        BoardList.add( boardDto );
        System.out.println("boardDto = " + boardDto);
        return true;
    }

    // 2. 전체 글 쓰기
    public List<BoardDto> findAll( ){
        System.out.println("BoardController.findAll");
        return BoardList;
    } // f end


    // 3. 개별 글 조회
    public BoardDto findByBno( int bno ){
        System.out.println("BoardController.findByBno");
        BoardDto result = new BoardDto();

        for( int i = 0 ; i < BoardList.size() ; i++){
            BoardDto boardDto = BoardList.get(i);
            if( boardDto.getBno() == bno ){ return result = boardDto; }
        } // for end
        return null;
    } // f end

    // 4. 개별 글 수정
    public boolean update( BoardDto boardDto ){
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
    public boolean delete( int bno ){
        System.out.println("BoardController.delete");

        for( int i = 0 ; i < BoardList.size() ; i++){
            BoardDto board = BoardList.get(i);
            if( board.getBno() == bno ){ BoardList.remove(i); return true;  }
        } // for end
        return false;
    } // f end

}
