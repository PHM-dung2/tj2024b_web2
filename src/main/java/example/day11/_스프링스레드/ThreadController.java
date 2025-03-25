package example.day11._스프링스레드;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day11/thread")
@RequiredArgsConstructor
public class ThreadController {

    private final ThreadService threadService;

    // (1) 비동기 = 기본값
    @GetMapping("/start1")
    public void thread1(){
        System.out.println("ThreadController.thread1");
        threadService.thread1();
    }

    // (2) 동기
    @GetMapping("/start2")
    public void thread2(){
        System.out.println("ThreadController.thread2");
        threadService.thread2();
    }




}
