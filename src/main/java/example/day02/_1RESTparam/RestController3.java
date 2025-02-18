package example.day02._1RESTparam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/day02")
public class RestController3 {

    // [1] HTTP servlet 내장 객체 : HTTPServletRequest
    @GetMapping("/doget1") // [GET] http://localhost:8080/day02/doget1?name=유재섟
    public void method1( HttpServletRequest req, HttpServletResponse resp ) throws Exception {
        System.out.println("RestController3.method1"); // soutm 자동완성 : 현재 함수명 출력함수
        // (1) 서블릿 방식의 쿼리스트링 받기
        String name = req.getParameter("name");
        System.out.println("name = " + name); // soutb 자동완성 : 가장 가까운 변수 출력함수
        // (2) 서블릿 방식의 응답 하기
        resp.setContentType("application/json");
        resp.getWriter().println("True");
    } // f end

    // [2] 스프링 제공하는 방법
    // @RequestParam : HTTP Request(요청)의 URL 쿼리스트리 ㅇ매개변수를 매핑하는 어노테이션, GEt/POST/PUT/DELETE
    // 1. @RequestParam( name = "queryString매개변수명" ) 타입 변수명
    // -> queryString 매개변수명과 함수 매개변수명과 동일하면 생략해도 된다.
    // 2. @RequestParam( name = "name" , defaultValue = "홍길동" ) 타입 매개변수명
    // -> 만약에 queryString 매핑할 매개변수명이 존재하지 않으면 기본값 설정
    // 3. @RequestParam( required = true )
    // -> 기본값이 true이며, 쿼리스트링 매개변수 필수 여부 설정, 만약에 쿼리스트링 매개변수가 없으면 400(Bad Request 잘못된 요청) 응답 // 500(JAVA 오류)

    @GetMapping("/doget2") // [GET] http://localhost:8080/day02/doget2?name=유재석
    // 3. ( required = "홍길동" )_
    public boolean method2( @RequestParam( name = "name" , defaultValue = "홍길동" , required = false ) String name ){ // 매핑하미수의 매개변수를 자동으로 쿼리스트링의 매개변수를 매핑/연결한다.
        System.out.println("RestController3.method2");
        System.out.println("name = " + name); // soutp 자동완성 : 현재 함수의 매개변수 출력함수
        return true; // @ResponseBody 사용했을 때 자동으로 response를 'application/json' 타입으로 응답한다.
    } // f end

    // [3]
    @GetMapping("/doget3") // [GET] http://localhost:8080/day02/doget3?name=유재석&age=40
    public int method3( @RequestParam( name = "name" ) String name ,
                        @RequestParam( name = "age" ) int age ){ // + 자동타입 변환이 된다.
        System.out.println("RestController3.method3"); // soutm
        System.out.println("name = " + name + ", age = " + age); // soutp
        return 3;
    } // f end

    // [3] 컬렙션 프레임워크를 이용한 쿼리스트링 매개변수 매핑
    @GetMapping("/doget4") // [GET] http://localhost:8080/day02/doget4?name=유재석&age=40
    public String method4( @RequestParam Map<String, String> map ){ // 여러 개의 매개변수를 하나의 map으로 받을 수 있다.
        System.out.println("RestController3.method4"); // soutm
        System.out.println("map = " + map); // soutp
        return "hello";
    } // f end\

    // [4] Dto 이용한 쿼리스트링 매개변수 매핑
    // + @ModelAttribute                        vs @RequestParam
    // 생략가능(기본값)                            명시해야한다
    // 공식타입 + 개발자가 만든 타입(DTO)            공식적타입만 지원 : 기본타입 + List, Map, String
    // 쿼리스트링, form첨부파일                     쿼리스트링 지원

    // + DTO 사용시 쿼리스트링 매개변수와 멤버변수명을 통일한다.
    @GetMapping("/doget5") // [GET] http://localhost:8080/day02/doget5?name=유재석&age=40
    public boolean method5( MemberDto memberDto ){ // 여러 개의 매개변수를 하나의 DTO로 받을 수 있다. // + @RequestParam 생략
        System.out.println("RestController3.method5");
        System.out.println("memberDto = " + memberDto);
        return true; // 아무거나
    } // f end

}
