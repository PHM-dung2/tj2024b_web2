package example.day03.mvc2_mybatis.controller;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import example.day03.mvc2_mybatis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/day03")
@RestController // 1. HTTP servlet 매핑 지원 // 2. ResponseBody 포함 // 3. 컨테이너 빈 등록 @Component
public class MyController {

    // * 스프링 컨테이너에서 객체/인스턴스를 주입
    @Autowired private MyService myService;

    // (1) PostMapping
    @PostMapping("/save")
    public int save(@RequestBody MyDto myDto ){
        System.out.println("MyController.save"); // soutm 자동완성 : 메소드명
        System.out.println("myDto = " + myDto); // soutp  자동완성 : 매개변수 출력
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        int result = myService.save(myDto);
        return result;
    }

    // (2) GetMapping
    @GetMapping("/findall")
    public List<MyDto> findAll(){
        System.out.println("MyController.findAll");
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        List<MyDto> result = myService.findAll();
        return result;
    }

    // (3) GetMapping
    @GetMapping("/find")
    public MyDto find(@RequestParam("id") int id ){
        System.out.println("MyController.find");
        System.out.println("id = " + id);
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        MyDto result = myService.find(id);
        return result;
    }

    // (4) PutMapping
    @PutMapping("/update")
    public int update( @RequestBody MyDto myDto ){
        System.out.println("MyController.update");
        System.out.println("myDto = " + myDto);
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        int result = myService.update( myDto );
        return result;
    }

    // (5) DeleteMapping("/day03/delete")
    @DeleteMapping("/delete")
    public int delete( @RequestParam("id") int id ){
        System.out.println("MyController.delete");
        System.out.println("id = " + id);
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        int result = myService.delete( id );
        return result;
    }

}
