package example.day08.model.mapper;

import example.day08.model.dto.ProductDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert( "INSERT INTO productsample( name, price, comment ) VALUES( #{name}, #{price}, #{comment} )")
    boolean write(ProductDto productDto);
    @Select( "SELECT * FROM productsample")
    List<ProductDto> findAll();
    @Update( "UPDATE productsample SET name = #{name}, price = #{price}, comment = #{comment} WHERE id = #{id}" )
    boolean update(ProductDto productDto);
    @Delete( "DELETE FROM productsample WHERE id = #{id}")
    boolean delete(int id);
}
