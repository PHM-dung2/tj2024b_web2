package web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 빈 등록 // 스프링 시작될 떄 해당 클래스를 읽어들인다.
public class CorsConfig implements WebMvcConfigurer {
    // (1) implements WebMvcConfigurer : spring mvc 관련 설정값을 수정하는 인터페이스
    // (2) CORS 관련 설정값 수정, 오버라이딩(재정의), addCorsMapping 메소드

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 스프링 컨트롤러의 매핑에 대해서
                .allowedOrigins("http://localhost:5173" , "http://localhost:5173" )
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드들
                .allowedHeaders("*") // HTTP의 헤더(body)정보 허용
                .allowCredentials(true); // HTTP의 쿠키/인증 허용(세션때문) // 마지막에 ;(세미콜론) 마침
    } // f end

}
