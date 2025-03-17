package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.model.dto.MemberDto;

@Mapper // 해당 인터페이스가 mapper임을 주입
public interface MemberMapper {

    // [1] 회원가입 -> 입력받은 자료를 등록 -> INSERT
    @Insert("insert into member( mid, mpwd, mname, mimg) VALUES( #{mid}, #{mpwd}, #{mname}, #{mimg} )")
    public boolean signUp(MemberDto memberDto);

    // [2] 로그인 -> 입력받은 자료를 확인/검증 -> SELECT
    @Select("SELECT mno, mid, mname, mimg FROM member WHERE mid = #{mid} AND mpwd = #{mpwd}")
    // boolean login( MemberDto memberDto );     // boolean : select 결과가 있으면 true, 없으면 null 이라서 오류가 발생할 수 있다.
    public MemberDto login(MemberDto memberDto); // MemberDto : select 결과가 있으면 memberDto, 없으면 null
    // 관례적으로 로그인은 Dto를 많이 쓴다.
}
