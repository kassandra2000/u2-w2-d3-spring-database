package kassandrafalsitta.u2w2d3.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Blog {
    private int id ;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;

}
