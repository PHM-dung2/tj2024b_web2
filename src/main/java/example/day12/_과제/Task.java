package example.day12._과제;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

@NoArgsConstructor @Getter
class MethodRef{
    public List<String> 과일들;
    public String 과일;
    public void onForEach( List<String> 과일들 ){
        과일들.stream().forEach( (과일) -> System.out.println( 과일 ) );
    } // f end

    public void onMessage( String 과일 ){
        System.out.println( 과일 );
    }
}

public class Task {
    public static void main(String[] args) {
        List<String> 과일들 = List.of("사과", "바나나", "체리", "대추", "포도");

        // 1.[메소드 레퍼런스 사용안함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
        System.out.println(">> 과제 1번 =================================================");
        과일들.stream().forEach( (과일 ) -> System.out.println( 과일 ) );

        // 2.[메소드 레퍼런스 사용안함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
        System.out.println(">> 과제 2번 =================================================");
        과일들.stream()
                .map( ( 과일 ) -> 과일 )
                .forEach( 과일 -> System.out.println( 과일 ) );

        // 3.[메소드 레퍼런스 사용안함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
        System.out.println(">> 과제 3번 =================================================");
        과일들.stream()
                .filter( (과일 ) -> 과일 == "바나나" || 과일 == "대추" )
                .forEach( 과일 -> System.out.println( 과일 ) );

        // 4.[메소드 레퍼런스 사용안함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
        System.out.println(">> 과제 4번 =================================================");
        과일들.stream()
                .sorted(Comparator.reverseOrder() )
                .forEach( 과일 -> System.out.println( 과일 ) );

        // 5.[메소드 레퍼런스 사용함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
        System.out.println(">> 과제 5번 =================================================");
        Supplier<MethodRef> ref = MethodRef::new;
        MethodRef methodRef = ref.get();
//        methodRef.onForEach( 과일들 );
        과일들.forEach( methodRef::onMessage );

        // 6.[메소드 레퍼런스 사용함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
        System.out.println(">> 과제 6번 =================================================");
        과일들.stream()
                .map( (과일) -> 과일 )
                .forEach( methodRef::onMessage );

        // 7.[메소드 레퍼런스 사용함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
        System.out.println(">> 과제 7번 =================================================");
        과일들.stream()
                .filter( ( 과일 ) -> 과일 == "바나나" || 과일 == "대추" )
                .forEach( methodRef::onMessage );


        // 8.[메소드 레퍼런스 사용함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
        System.out.println(">> 과제 8번 =================================================");
        과일들.stream()
                .sorted( Comparator.reverseOrder() )
                .forEach( methodRef::onMessage );
    }
}
