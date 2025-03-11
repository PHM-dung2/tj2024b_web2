package example.day08.service;

import example.day08.model.dto.ProductDto;
import example.day08.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    // 0. 생성자
    @Autowired
    public ProductService( ProductMapper productMapper ){
        this.productMapper = productMapper;
    } // f end

    // 1. 제품 등록
    public boolean write( ProductDto productDto){
        System.out.println("ProductController.write");
        System.out.println("productDto = " + productDto);
        return productMapper.write( productDto );
    } // f end

    // 2. 제품 전체 조회
    public List<ProductDto> findAll(){
        System.out.println("ProductController.findAll");
        return productMapper.findAll();
    } // f end

    // 3. 제품 수정
    public boolean update( ProductDto productDto ){
        System.out.println("ProductController.update");
        System.out.println("productDto = " + productDto);
        return productMapper.update( productDto );
    } // f end

    // 4. 제품 삭제
    public boolean delete(@RequestParam int id){
        System.out.println("ProductController.delete");
        System.out.println("id = " + id);
        return productMapper.delete( id );
    } // f end

}
