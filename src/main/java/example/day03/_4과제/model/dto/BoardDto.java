package example.day03._4과제.model.dto;

import lombok.*;

@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardDto {
    private int bno;
    private String title;
    private String content;
}
