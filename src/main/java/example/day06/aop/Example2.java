package example.day06.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Aspect
@Component
class Security{
    @Before("execution( * TestService2.*(..) )")
    // 지정한 메소드가 실행되기 전에 아래 메소드가 실행된다.
    // 지정한 메소드는 'TestService2' 클래스의 *(모든메소드) 이면서 (..)모든매개변수타입 *(모든리턴타입)
        // 즉) 'TestService2' 모든 메소드들은 실행되기 전에 'securityCheck' 메소드가 *자동*으로 실행된다.
    public void securityCheck(){
        System.out.println("메소드 실행 전(before) : (보안) [코로나] 온도 체크");
    } // f end

    @After( "execution( * example.day06.aop.TestService2.enter1(..))")
    // 지정한 메소드가 실행 후 아래 메소드가 실행된다.
    // 지정한 메소드는 'TestService2' 클래스의 'enter1'(특정메소드) 이면서 (..)모든매개변수타입 , *(모든리턴타입)
        // 즉) 'TestService2'의 enter1 메소드가 실행된 후 에 'sercurityCheck2' 메소드가 *자동*으로 실행된다.
    public void securityCheck2(){
        System.out.println("메소드 실행 후(after) : 함수 실행 종료");
    } // f end
}

@Service
class TestService2 {
    // 메소드1
    public void enter1(){
        // 부가기능 제외한 상태
        // new Security().securityCheck(); // [1] 일반적인 코드 재사용
        System.out.println("식당 입장"); // 비즈니스 로직
    } // f end

    // 메소드2
    public void enter2(){
        // 부가기능 제외한 상태
        // new Security().securityCheck(); // [1] 일반적인 코드 재사용
        System.out.println("학원 입장"); // 비즈니스 로직
    } // f end
}

@RestController
class TestController{
    @Autowired private TestService2 testService2;
    @GetMapping("/day06/aop")
    public void aop(){
        testService2.enter1();
        testService2.enter2();
    }
}

@SpringBootApplication
public class Example2 {
    public static void main(String[] args) {
        SpringApplication.run( Example2.class );
    }
}
