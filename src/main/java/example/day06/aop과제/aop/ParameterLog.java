package example.day06.aop과제.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterLog {

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
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long timeMs = endTime - startTime;

        System.out.println("실행된 시간 : " + timeMs + "ms");
        return result;
    } // f end

}
