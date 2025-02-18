package example.day02._3과제;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class BoardDto {
    private int bno;
    private String title;
    private String content;
}
