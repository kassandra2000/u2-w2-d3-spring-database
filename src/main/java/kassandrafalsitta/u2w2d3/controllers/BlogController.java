package kassandrafalsitta.u2w2d3.controllers;

import com.example.demo.entities.Blog;
import com.example.demo.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private Blog getBlogById(@PathVariable int blogId){
        return blogService.findById(blogId);
    }

    @PutMapping("/{blogId}")
    private Blog findBlogByIdAndUpdate(@PathVariable int blogId, @RequestBody Blog body){
        return blogService.findByIdAndUpdate(blogId, body);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findBlogByIdAndDelete(@PathVariable int blogId){
        blogService.findByIdAndDelete(blogId);
    }
}
