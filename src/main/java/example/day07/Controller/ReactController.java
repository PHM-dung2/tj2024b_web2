package example.day07.Controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day07/react")
@CrossOrigin("http://192.168.40.45:5173") // CORS 정책 허용, 특정 url만 허용 가능하도록 한다, 우리의 리액트 서버 허용
public class ReactController {

    private List< Map<Object, String> > boards = new ArrayList<>();

    // [1] POST
    @PostMapping
    // [POST] http://localhost:8080/day07/react
    // { "writer" : "유재석", "content" : "안녕하세요", "pwd" : "1234" }
    public boolean onPost(@RequestBody Map<Object, String> map ){
        System.out.println("ReactController.onPost"); // soutm
        System.out.println("map = " + map); // soutp
        boards.add(map);
        return true;
    } // f end

    @GetMapping
    public List< Map<Object, String> > onFindAll(){
        System.out.println("ReactController.onFindAll");
        return boards;
    } // f end

    @PutMapping
    public boolean onUpdate(){

        return true;
    } // f end

    @DeleteMapping
    public boolean onDelete(){

        return true;
    } // f end

}
