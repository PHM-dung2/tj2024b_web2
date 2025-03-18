package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service // 해당 클래스가 service임을 주입
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final FileService fileService; // 파일 서비스(업로드, 다운로드, 파일삭제) 기능 포함

    // [1] 회원가입
    public boolean signUp(MemberDto memberDto){
        System.out.println("MemberController.signUp");
        System.out.println("memberDto = " + memberDto);
        try {
            // (1) 만약에 첨부파일(프로필업로드) 존재하는지 검사
            if (memberDto.getUploadFile() == null) {
            } // 업로드가 존재하지 않으면
            else { // 업로드가 존재하면 파일서비스의 업로드 메소드 사용하기
                // (2) 파일서비스 내 업로드 함수 이용하여 첨부파일 업로드하고 파일명 받기
                String fileName = fileService.fileUpload(memberDto.getUploadFile());
                // (3) 업로드된 파일명을 dto 저장
                memberDto.setMimg(fileName);
            }
            boolean result = memberMapper.signUp(memberDto);
            System.out.println("result = " + result);
            return result;
        }catch( Exception e ){ return false; } // 업로드 외 회원가입DB 처리 중 예외 발생시 false 반환
    } // f end

    // [2] 로그인
    public MemberDto login(MemberDto memberDto){
        System.out.println("MemberController.login");
        System.out.println("memberDto = " + memberDto);
        return memberMapper.login(memberDto);
    } // f end


}
