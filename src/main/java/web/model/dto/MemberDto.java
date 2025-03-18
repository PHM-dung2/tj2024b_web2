package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data // @Getter @Setter @ToString 등등 포함
@NoArgsConstructor // 전체 생성자
@AllArgsConstructor // 빈 생성자
@Builder // 빌더패턴 지원
public class MemberDto {
    // + DB 테이블 필요
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mimg; // [DB] 업로드된 파일의 파일명
    // + 그외
    private MultipartFile uploadFile; // [FORM전송] 등록시 업로드된 파일의 바이트 인터페이스
    // private List<MultipartFile> uploadFiles; // 등록시 여러개 업로드된 파일 조작
}
