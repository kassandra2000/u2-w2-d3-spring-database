package kassandrafalsitta.u2w2d3.controllers;

import kassandrafalsitta.u2w2d3.entities.Blog;
import kassandrafalsitta.u2w2d3.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    private List<Blog> getAllBlogs(){
        return blogService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Blog createBlog(@RequestBody Blog body){
        return blogService.saveBlog(body);
    }

    @GetMapping("/{blogId}")
    private Blog getBlogById(@PathVariable UUID blogId){
        return blogService.findById(blogId);
    }

    @PutMapping("/{blogId}")
    private Blog findBlogByIdAndUpdate(@PathVariable UUID blogId, @RequestBody Blog body){
        return blogService.findByIdAndUpdate(blogId, body);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findBlogByIdAndDelete(@PathVariable UUID blogId){
        blogService.findByIdAndDelete(blogId);
    }
}
