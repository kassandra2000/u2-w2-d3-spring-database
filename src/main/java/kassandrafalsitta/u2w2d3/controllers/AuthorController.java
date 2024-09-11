package kassandrafalsitta.u2w2d3.controllers;

import com.example.demo.entities.Author;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private Author getAuthorById(@PathVariable int authorId) {
        return authorService.findById(authorId);
    }

    @PutMapping("/{authorId}")
    private Author findAuthorByIdAndUpdate(@PathVariable int authorId, @RequestBody Author body) {
        return authorService.findByIdAndUpdate(authorId, body);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAuthorByIdAndDelete(@PathVariable int authorId) {
        authorService.findByIdAndDelete(authorId);
    }
}
