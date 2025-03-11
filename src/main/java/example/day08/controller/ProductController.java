package example.day08.controller;

import example.day08.model.dto.ProductDto;
import example.day08.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day08/product")
@CrossOrigin("http://192.168.40.45:5173")
public class ProductController {

    private final ProductService productService;

    // 0. 생성자
    @Autowired
    public ProductController( ProductService productService ){
        this.productService = productService;
    } // f end

    // 1. 제품 등록
    @PostMapping
    public boolean write(@RequestBody ProductDto productDto){
        System.out.println("ProductController.write");
        System.out.println("productDto = " + productDto);
        return productService.write( productDto );
    } // f end

    // 2. 제품 전체 조회
    @GetMapping
    public List<ProductDto> findAll(){
        System.out.println("ProductController.findAll");
        return productService.findAll();
    } // f end

    // 3. 제품 수정
    @PutMapping
    public boolean update(@RequestParam int id, @RequestBody ProductDto productDto ){
        System.out.println("ProductController.update");
        productDto.setId(id);
        System.out.println("productDto = " + productDto);
        return productService.update( productDto );
    } // f end

    // 4. 제품 삭제
    @DeleteMapping
    public boolean delete(@RequestParam int id){
        System.out.println("ProductController.delete");
        System.out.println("id = " + id);
        return productService.delete( id );
    } // f end


}
