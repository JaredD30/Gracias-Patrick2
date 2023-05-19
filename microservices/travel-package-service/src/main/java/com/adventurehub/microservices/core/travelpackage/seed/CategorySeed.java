package com.adventurehub.microservices.core.travelpackage.seed;

import com.adventurehub.microservices.core.travelpackage.entity.CategoryEntity;
import com.adventurehub.microservices.core.travelpackage.mapper.CategoryMapper;
import com.adventurehub.microservices.core.travelpackage.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.magnus.api.core.category.Category;

import java.util.Arrays;

@Service
public class CategorySeed {
    @Autowired
    private  CategoryRepository categoryRepository;
    @Autowired
    private  CategoryMapper mapper;

    private static String[] DEFAULT_CATEGORY = {"Adventure", "Beach", "City Break", "Cultural", "Family", "Honeymoon", "Luxury", "Nature", "Safari", "Sports", "Wellness"};

    public CategorySeed(CategoryRepository categoryRepository, CategoryMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public void seed() {
        Arrays.stream(DEFAULT_CATEGORY)
                .forEach(name -> {
                    if(!categoryRepository.existsByName(name)) {
                        Category newCategory = new Category();
                        newCategory.setName(name);
                        CategoryEntity categoryEntity = mapper.apiToEntity(newCategory);
                        categoryRepository.save(categoryEntity);
                    }
                });
    }
}
