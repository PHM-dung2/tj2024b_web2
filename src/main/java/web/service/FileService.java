package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service // 해당 클래스가 서비스입을 빈 등록
public class FileService {

    // [*] 업로드된 파일을 저장할 폴더 경로, resources(폴더)
    // src -> main -> resources -> static -> upload
    // 1. 현재 프로젝트 최상위 디렉토리(폴더) 경로찾기
    String baseDir = System.getProperty("user.dir"); // 현재 작업중인 최상위(프로젝트 절대경로) 폴더를 반환한다.
    // -> C:\Users\tj-bu-702-02\Desktop\HM ,[PC마다 다르다]
    // 2. src 외 build 폴더 차이점 : src(실행전코드) vs build(실행후코드)
    // * 개발자는 src에서 작업하고 항상 서버를 실행함으로써 작업한 코드를 build로 반영한다.( 컴파일/빌드 )
    // * 업로드는 개발자의 src에 업로드하지않고 배포/빌드된 build 폴더에 업로드한다.
    // String uploadPath = "/src/resources/static/upload/";
    // -> C:/Users/tj-bu-702-02/Desktop/HM/build/resources/main/static/upload/
    String uploadPath = baseDir + "/build/resources/main/static/upload/";

    // [1] 업로드 : 스프링에서는 Multipart 인터페이스 지원함으로써 파일 업로드 지원
    public String fileUpload(MultipartFile multipartFile){ // (1) 매개변수로 'MultipartFile' 인터페이스 타입을받는다ㅣ
        // (2) multipartFile 인터페이스 내 다양한 메소드 제공한다.
        System.out.println( multipartFile.getContentType() ); // 첨부파일의 확장자 반환
        System.out.println( multipartFile.getSize() ); // 첨부파일의 용량(바이트) 반환
        System.out.println( multipartFile.getOriginalFilename() ); // 첨부파일의 파일명 반환
        System.out.println( multipartFile.isEmpty() ); // 첨부파일이 있다 true, 없다 false 반환

        // (3) 업로드할 경로 만들기 // '업로드할 기본경로'와(+) '파일명'
            // (*) 동일한 파일명으로 업로드할 경우 식별이 불가능하다. 해결방안 : UUID, 식별자 생성
        String uuid = UUID.randomUUID().toString(); // 임의의 UUID 규약에 따른 난수 문자열 생성(고유성 보장)
            // (*) uuid와(+) 파일명( 파일명에 _언더바가 존재하면 -하이픈으로 모두 변경 ), _언더바는 uuid와 파일명 구분하는 용도
        String fileName = uuid + "_" + multipartFile.getOriginalFilename().replaceAll("_","-");
            // (*) 업로드 기본경로 + uuid 포함된 파일명
        String filePath = uploadPath + fileName;

        // (4) File 클래스 : File 관련된 다양한 메소드 제공하는 클래스
        File file = new File( filePath ); // new File( 파일경로 );

        // (5) 경로에 업로드하기, transferTo( file객체 )
        try{ multipartFile.transferTo( file );
        }catch ( IOException e){ System.out.println( e ); return null; } // 만일 업로드 실패시 null 반환
        return fileName; // 만일에 업로드 성공시 업로드한 파일명 반환
    } // f end

    // [2] 업로드된 파일 다운로드

     // [3] 업로드된 파일 삭제

}
