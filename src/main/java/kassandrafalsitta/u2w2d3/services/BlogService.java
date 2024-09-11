package kassandrafalsitta.u2w2d3.services;

import com.example.demo.entities.Blog;
import com.example.demo.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private final List<Blog> blogsList = new ArrayList<>();

    public List<Blog> findAll() {
        return this.blogsList;
    }

    public Blog saveBlog(Blog body) {
        Random r = new Random();
        body.setId(r.nextInt(99999, 999999999));
        this.blogsList.add(body);
        return body;
    }

    public Blog findById(int blogId) {
        return this.blogsList.stream()
                .filter(blog -> blog.getId() == blogId).findFirst()
                .orElseThrow(() -> new NotFoundException(blogId));
    }

    public Blog findByIdAndUpdate(int blogId, Blog updatedBlog) {
        Blog found = findById(blogId);
        found.setCategory(updatedBlog.getCategory());
        found.setTitle(updatedBlog.getTitle());
        found.setReadingTime(updatedBlog.getReadingTime());
        found.setCover(updatedBlog.getCover());
        found.setContent(updatedBlog.getContent());

        return found;
    }

    public void findByIdAndDelete(int blogId) {
        this.blogsList.remove(findById(blogId));
    }
}
