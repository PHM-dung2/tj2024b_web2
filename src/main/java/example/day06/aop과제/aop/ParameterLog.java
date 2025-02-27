package example.day06.aop과제.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ParameterLog {

    // [*] @Before / @AfterReturning 사용하지 않고 @Around 하나로 표현
    @Around( "execution(* example.day06.aop과제.service.StudentService.*(..))" )
    public Object TaskServiceCheck( ProceedingJoinPoint joinPoint ) throws Throwable {
        // * 지정한 함수 시그니처 출력
        System.out.println("[실행메소드] : " + joinPoint.getSignature() );
        // 1. 매개병수 출력
        // Arrays.toString( 배열변수 ) : 배열 출력을 주소값이 아닌 값으로 반환
        System.out.println("[매개변수] : " + Arrays.toString( joinPoint.getArgs() ) );
        // * 지정한 함수 실행
        Object result = joinPoint.proceed();
        // 2. 반환값 출력
        System.out.println("[반환값] : " + result );
        // * 지정한 함수의 반환 값 그대로 반환
        return result;
    } // f end

/*
    @Before( "execution( * example.day06.aop과제.service.StudentService.save(..))" )
    public void logMethodName(){
        System.out.println("\n메소드 실행전(before) : StudentController.save 실행");
    } // f end

    @Before( "execution( * example.day06.aop과제.service.StudentService.findAll(..))" )
    public void logMethodName2(){
        System.out.println("\n메소드 실행전(before) : StudentController.findAll 실행");
    } // f end

    @Before( "execution( * example.day06.aop과제.service.StudentService.*(..) ) && args(name) ")
    public void logParameter( Object name ){
        System.out.println("메소드 실행전(before) : " + name );
    } // f end

    @AfterReturning( value = "execution(* example.day06.aop과제.service.StudentService.*(..))" , returning = "result" )
    public void logResult( Object result ){
        System.out.println("메소드 실행후(after) 리턴값 : " + result );
    } // f end

    @Around( "execution( * example.day06.aop과제.service.StudentService.*(..))" )
    public Object afterTimeCheck( ProceedingJoinPoint joinPoint ) throws Throwable  {

        // ProceedingJoinPoint.proceed() : proceedingJoinPoint : AOP에서 사용되는 인터페이스
        // 제공하는 메소드
        // 1. .proceed() : 지정한 메소드를 실행하는 메소드
        System.out.println( joinPoint.getArgs() ); // 지정한 메소드의 매개변수 반환(배열타입)
        System.out.println( joinPoint.getSignature() ); // 지정한 메소드의 시그니처 반환(실행된 메소드의 리턴타입, 함수명, 매개변수 반환)
        System.out.println( joinPoint.getTarget() ); // 지정한 메소드를 실행한 객체(TaskService 객체)

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long timeMs = endTime - startTime;

        System.out.println("실행된 시간 : " + timeMs + "ms");
        return result;
    } // f end
*/

}
