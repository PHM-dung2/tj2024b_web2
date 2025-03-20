package example.day09;

import lombok.Builder;

@Builder // 롬복에서 빌더 패턴 지원
class MemberDto{
    private String name;
    private int age;

    public MemberDto( String name, int age ){
        this.name = name;
        this.age = age;
    }
}

public class Example1 {
    public static void main(String[] args) {
        // (1) (객체) MemverDto 생성할 때 멤버변수에 초긱밧을 대입하는 방법( !!생성자!! )
        MemberDto memberDto0 = new MemberDto( "유재석", 40 );
            // MemberDto memberDto1 = new MemberDto( ); // 존재하지 않은 생성자 사용
            // MemberDto memberDto2 = new MemberDto( "유재석" ); // 정의된 생성자가 없어서 // 정의된 생성자의 매개변수를 일치하지 않아서
            // MemberDto memberDto3 = new MemberDto( 40, "유재석" ); // 정의된 생성자가 없어서 // 정의된 생성자의 매개변수를 일치하지 않아서
            // MemberDto memberDto4 = new MemberDto( "유재석", 40, "연예인" ); // 정의된 생성자가 없어서 // 정의된 생성자의 매개변수를 일치하지 않아서

        // 생성자 규칙 :
        // 1. 정의(만든)된 생성자만 사용이 가능하다, 만든 생성자가 1개도 없을 때는 기본생성자가 자동으로 생성된다.
        // 2. 매개변수의 순서와 타입, 개수 일치해야한다.

        // 다양한 생성자를 사용하면 복잡도 올라간다. -> Builder Pattern
        // ! 빌더패턴 @Builder : 복잡한 객체 생성 과정을 단순화 해주는 디자인 패턴
        // (2) 롬복 제공하는 @Builder 어노테이션 객체 생성
            // 클래스명.builder().필드명(초기값).필드명(초기값).builde() : 빌더 객체를 생성
        MemberDto memberDto5 = MemberDto.builder().name("유재석").age(40).build();
        MemberDto memberDto6 = MemberDto.builder().build();
        MemberDto memberDto7 = MemberDto.builder().name("유재석").build();
        MemberDto memberDto8 = MemberDto.builder().age( 40 ).build();

    }
}
