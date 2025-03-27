package example.day13;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TranMapper {

    @Insert("INSERT INTO day13users( name ) values( #{name} )")
    public boolean tran( String name );

}
