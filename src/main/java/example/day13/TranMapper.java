package example.day13;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TranMapper {

    // (1)
    @Insert( "INSERT INTO day13users( name ) values( #{name} )" )
    public boolean tran( String name );

    // (2) 출금, 빼기
    @Update( "UPDATE day13users " +
             "SET money = money - #{money} " +
             "WHERE name = #{name} ")
    public boolean withdraw( String name, int money );

    // (2) 입금, 더하기
    @Update( "UPDATE day13users " +
             "SET money = money + #{money} " +
             "WHERE name = #{name} ")
    public boolean deposit( String name, int money );

    // (3) 모든 회원 목록 조회
    @Select( "SELECT name FROM day13users" )
    public List< String > findAll();

    // (4)

}
