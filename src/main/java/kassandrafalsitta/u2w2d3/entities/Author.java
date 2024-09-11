package kassandrafalsitta.u2w2d3.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author {
    private int id ;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    private String avatar;

    //costruttore
    public Author(String name, String surname, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
}
