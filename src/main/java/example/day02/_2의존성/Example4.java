package example.day02._2의존성;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
    [ 스프링 방법4 : IOC와 DI ] *권장
*/
@Service // @Service에는 @Component 포함
class SampleService4{
     void method(){
         System.out.println("SampleService4.method");
     } // f end
}

class SampleController4{
    // Static : 전역키워드 , fianl : 수정불가키워드
    private final SampleService4 sampleService4;

    @Autowired // 생성자를 이용하여 빈 등록하는 방법
    public SampleController4( SampleService4 sampleService4 ){
        this.sampleService4 = sampleService4;
    }

    public void method(){
        sampleService4.method();
    }
}

public class Example4 {
}
