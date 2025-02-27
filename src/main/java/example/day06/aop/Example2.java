package example.day06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    // [3]
    @Before( "execution( * example.day06.aop.TestService2.enter3(..)) && args(name)" )
    // 지정한 메소드에서 name 매개변수를 가지고 와서 아래 메소드에서 사용이 가능하다.
        // 로그처리, 보안검사 , 트랜잭션 등등 하기 위해서
    public void securityCheck3( String name ){
        System.out.println("메소드 실행 전(before) : " + name + " 님이 코로나 검사 완료");
    } // f end

    // [4]
    @AfterReturning( value = "execution( * example.day06.aop.TestService2.enter3(..) )" , returning = "result" )
    // 지정한 메소드에서 정상적으로 실행되었을 때 result 리턴값을 가지고 와서 아래 메소드에서 사용이 가능하다.
        // 즉) 'TestService2' enter3 메소드가 실행 후 return 값을 가지고 'securityCheck4' 실행
    public void securityCheck4( Object result ){ // 모든 매개변수들의 타입을 대입하기 위해서
        System.out.println("메소드 실행 후(after) : " + result + " 이/가 결과값이 정상");
    } // f end

    // [5]
    @Around( "execution( * example.day06.aop.TestService2.enter3(..) )")
    public Object timeCheck( ProceedingJoinPoint joinPoint ) throws Throwable  {
        // ProceedingJoinPoint : 지정한 메소드와 그 외 로직과 조합해서 구현
        // --> 추가 로직에서 직접 지정한 메소드 호출 : joinPoint.proceed(); , 예외처리 필수
        // (1) 시작 시간
        long startTime = System.currentTimeMillis(); // System.currentTimeMillis() : 현재 시간을 밀리초(1/1000초) 반환
        Object result = joinPoint.proceed(); // 지정한 메소드( 'enter3' ) 실행
        // (2) 끝나는 시간
        long endTime = System.currentTimeMillis(); // 현재 시간을 밀리초(1/1000초) 반환
        // (3) 지정된 메소드가 실행했을 때 걸린 시간 계산
        long timeMs = endTime - startTime;
        // (4) 걸린 시간 출력
        System.out.println("enter3 메소드가 실행된 시간 : " + timeMs + "ms");
        // (5) 지정된 메소드가 리턴한 값 그대로 리턴
        return result;
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

    // 메소드3
     public boolean enter3( String name ){
         System.out.println( "헬스장 입장" ); // 비즈니스 로직
         return true;
     } // f end
}

@RestController
class TestController{
    @Autowired private TestService2 testService2;
    @GetMapping("/day06/aop")
    public void aop(){
        testService2.enter1();
        testService2.enter2();
        testService2.enter3("강호동");
    }
}

@SpringBootApplication
public class Example2 {
    public static void main(String[] args) {
        SpringApplication.run( Example2.class );
    }
}
