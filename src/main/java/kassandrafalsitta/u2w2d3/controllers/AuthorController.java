package kassandrafalsitta.u2w2d3.controllers;

import kassandrafalsitta.u2w2d3.entities.Author;
import kassandrafalsitta.u2w2d3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    private List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author createAuthor(@RequestBody Author body) {
        return authorService.saveAuthor(body);
    }

    @GetMapping("/{authorId}")
    private Author getAuthorById(@PathVariable UUID authorId) {
        return authorService.findById(authorId);
    }

    @PutMapping("/{authorId}")
    private Author findAuthorByIdAndUpdate(@PathVariable UUID authorId, @RequestBody Author body) {
        return authorService.findByIdAndUpdate(authorId, body);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAuthorByIdAndDelete(@PathVariable UUID authorId) {
        authorService.findByIdAndDelete(authorId);
    }
}
