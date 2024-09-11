package kassandrafalsitta.u2w2d3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorId;


}
