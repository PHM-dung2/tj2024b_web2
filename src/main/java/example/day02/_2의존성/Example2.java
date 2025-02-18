package example.day02._2의존성;

import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    [고전적인 방법2 : 싱글톤 생성]
    스프링 없이 싱글톤(인스턴스)를 직접 생성하여 메소드를 사용한다.
    - 이유 : 프로그램 내 하나의 인스턴스(객체)가 하나만 필요로 할 떄 사용한다. 주로 controller, Dao
*/
// [1] 서비스 클래스
@NoArgsConstructor
class SampleService2{
    @Getter
    // 싱글톤 만들기
    private static SampleService2 instance = new SampleService2();

    void method(){
        System.out.println("SampleService2.method");
    }
}
// [2] 컨트롤러 클래스
class SampleController{
    SampleService2 sampleService2 = new SampleService2();
    public void method(){
        sampleService2.method();
    }
}

public class Example2 {
}
