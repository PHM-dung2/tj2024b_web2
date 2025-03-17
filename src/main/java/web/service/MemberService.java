package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service // 해당 클래스가 service임을 주입
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    // [1] 회원가입
    public boolean signUp(MemberDto memberDto){
        System.out.println("MemberController.signUp");
        System.out.println("memberDto = " + memberDto);
        return memberMapper.signUp(memberDto);
    } // f end

    // [2] 로그인
    public MemberDto login(MemberDto memberDto){
        System.out.println("MemberController.login");
        System.out.println("memberDto = " + memberDto);
        return memberMapper.login(memberDto);
    } // f end


}
