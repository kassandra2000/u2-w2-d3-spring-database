package kassandrafalsitta.u2w2d3.services;

import kassandrafalsitta.u2w2d3.entities.Blog;
import kassandrafalsitta.u2w2d3.exceptions.NotFoundException;
import kassandrafalsitta.u2w2d3.repositories.AuthorsRepository;
import kassandrafalsitta.u2w2d3.repositories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class BlogService {
    @Autowired
    private BlogsRepository blogsRepository;

    private final List<Blog> blogsList = new ArrayList<>();

    public List<Blog> findAll() {
        return this.blogsList;
    }

    public Blog saveBlog(Blog body) {
        Random r = new Random();
        this.blogsList.add(body);
        return body;
    }

    public Blog findById(UUID blogId) {
        return this.blogsList.stream()
                .filter(blog -> blog.getId() == blogId).findFirst()
                .orElseThrow(() -> new NotFoundException(blogId));
    }

    public Blog findByIdAndUpdate(UUID blogId, Blog updatedBlog) {
        Blog found = findById(blogId);
        found.setCategory(updatedBlog.getCategory());
        found.setTitle(updatedBlog.getTitle());
        found.setReadingTime(updatedBlog.getReadingTime());
        found.setCover(updatedBlog.getCover());
        found.setContent(updatedBlog.getContent());

        return found;
    }

    public void findByIdAndDelete(UUID blogId) {
        this.blogsList.remove(findById(blogId));
    }
}
