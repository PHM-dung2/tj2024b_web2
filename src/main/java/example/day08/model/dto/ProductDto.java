package example.day08.model.dto;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private int price;
    private String comment;
}
