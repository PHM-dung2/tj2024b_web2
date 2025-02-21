package example.day03.mvc2_mybatis.model.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter @Service @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class MyDto {
    private int id;
    private String name;
    private int age;
}
