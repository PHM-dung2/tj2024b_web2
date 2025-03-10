package example.day07.Controller;

import example.day07.model.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day07/task")
@CrossOrigin("http://192.168.40.45:5173")
public class TaskController {

    private final TaskMapper taskMapper;

    @Autowired
    public TaskController( TaskMapper taskMapper ){
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public boolean onWrite( @RequestBody Map<Object, String> map ){
        System.out.println("TaskController.onWrite");
        System.out.println("map = " + map);
        return taskMapper.onWrite( map );
    } // f end

    @GetMapping
    public List< Map<Object, String> > onFindAll(){
        System.out.println("TaskController.onFindAll");
        return taskMapper.onFindAll();
    }

}
