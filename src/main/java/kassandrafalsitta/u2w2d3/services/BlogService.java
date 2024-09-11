package kassandrafalsitta.u2w2d3.services;

import kassandrafalsitta.u2w2d3.entities.Author;
import kassandrafalsitta.u2w2d3.entities.Blog;
import kassandrafalsitta.u2w2d3.entities.BlogPayload;
import kassandrafalsitta.u2w2d3.exceptions.NotFoundException;
import kassandrafalsitta.u2w2d3.repositories.AuthorsRepository;
import kassandrafalsitta.u2w2d3.repositories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BlogService {
    @Autowired
    private BlogsRepository blogsRepository;
    @Autowired
    private AuthorsRepository authorsRepository;

    public Page<Blog> findAll(int page, int size, String sortBy) {
        if (page > 100) page = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.blogsRepository.findAll(pageable);
    }

    public Blog saveBlog(BlogPayload body) {
        Author author = authorsRepository.findById(body.getAuthorId()).orElseThrow(() -> new NotFoundException(body.getAuthorId()));
        Blog blog = new Blog(body.getCategory(), body.getTitle(), body.getCover(), body.getContent(), body.getReadingTime(), author);
        return this.blogsRepository.save(blog);
    }

    public Blog findById(UUID blogId) {
        return this.blogsRepository.findById(blogId).orElseThrow(() -> new NotFoundException(blogId));
    }

    public Blog findByIdAndUpdate(UUID blogId, BlogPayload updatedBlog) {
        Blog found = findById(blogId);
        found.setCategory(updatedBlog.getCategory());
        found.setTitle(updatedBlog.getTitle());
        found.setReadingTime(updatedBlog.getReadingTime());
        found.setCover(updatedBlog.getCover());
        found.setContent(updatedBlog.getContent());
        Author author = authorsRepository.findById(updatedBlog.getAuthorId()).orElseThrow(() -> new NotFoundException(updatedBlog.getAuthorId()));
        found.setAuthorId(author);
        return this.blogsRepository.save(found);
    }

    public void findByIdAndDelete(UUID blogId) {
        this.blogsRepository.delete(this.findById(blogId));
    }
}
