package com.example.demo.services;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
 
@Service

public class CategoryService {
 
    private final CategoryRepository repo;
 
    public CategoryService(CategoryRepository repo) {

        this.repo = repo;

    }
 
    public List<Category> findAll() {

        return repo.findAll();

    }
 
    public void save(Category category) {

        repo.save(category);

    }
 
    public Optional<Category> findById(Long id) {

        return repo.findById(id);

    }
 
    public void deleteById(Long id) {

        repo.deleteById(id);

    }

}

 