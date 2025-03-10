package example.day07.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {

    @Insert( "INSERT INTO phonebook( name, phone ) VALUES( #{name}, #{phone} )")
    boolean onWrite(Map<Object, String> map);

    @Select( "SELECT * FROM phonebook")
    List< Map<Object, String> > onFindAll();

}
