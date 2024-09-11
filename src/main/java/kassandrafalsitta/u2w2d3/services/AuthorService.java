package kassandrafalsitta.u2w2d3.services;

import com.example.demo.entities.Author;
import com.example.demo.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private final List<Author> authorsList = new ArrayList<>();

    public List<Author> findAll() {
        return this.authorsList;
    }

    public Author saveAuthor(Author body) {
        Random r = new Random();
        body.setId(r.nextInt(99999, 999999999));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
        this.authorsList.add(body);
        return body;
    }

    public Author findById(int authorId) {
        return this.authorsList.stream()
                .filter(author -> author.getId() == authorId).findFirst()
                .orElseThrow(() -> new NotFoundException(authorId));
    }

    public Author findByIdAndUpdate(int authorId, Author updatedAuthor) {
        Author found = findById(authorId);
        found.setName(updatedAuthor.getName());
        found.setSurname(updatedAuthor.getSurname());
        found.setEmail(updatedAuthor.getEmail());
        found.setDateOfBirth(updatedAuthor.getDateOfBirth());
        found.setAvatar(updatedAuthor.getAvatar());

        return found;
    }

    public void findByIdAndDelete(int authorId) {
        this.authorsList.remove(findById(authorId));
    }
}
