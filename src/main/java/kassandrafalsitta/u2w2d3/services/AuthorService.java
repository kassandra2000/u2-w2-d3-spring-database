package kassandrafalsitta.u2w2d3.services;

import kassandrafalsitta.u2w2d3.entities.Author;
import kassandrafalsitta.u2w2d3.exceptions.NotFoundException;
import kassandrafalsitta.u2w2d3.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    private AuthorsRepository authorsRepository;

    private final List<Author> authorsList = new ArrayList<>();

    public List<Author> findAll() {
        return this.authorsList;
    }

    public Author saveAuthor(Author body) {
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
        this.authorsList.add(body);
        return body;
    }

    public Author findById(UUID authorId) {
        return this.authorsList.stream()
                .filter(author -> author.getId() == authorId).findFirst()
                .orElseThrow(() -> new NotFoundException(authorId));
    }

    public Author findByIdAndUpdate(UUID authorId, Author updatedAuthor) {
        Author found = findById(authorId);
        found.setName(updatedAuthor.getName());
        found.setSurname(updatedAuthor.getSurname());
        found.setEmail(updatedAuthor.getEmail());
        found.setDateOfBirth(updatedAuthor.getDateOfBirth());
        found.setAvatar(updatedAuthor.getAvatar());

        return found;
    }

    public void findByIdAndDelete(UUID authorId) {
        this.authorsList.remove(findById(authorId));
    }
}
