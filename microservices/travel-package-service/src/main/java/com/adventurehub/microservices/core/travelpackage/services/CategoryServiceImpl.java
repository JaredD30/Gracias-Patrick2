package com.adventurehub.microservices.core.travelpackage.services;

import com.adventurehub.microservices.core.travelpackage.entity.CategoryEntity;
import com.adventurehub.microservices.core.travelpackage.mapper.CategoryMapper;
import com.adventurehub.microservices.core.travelpackage.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.category.Category;
import se.magnus.api.core.category.CategoryService;
import se.magnus.util.http.ServiceUtil;

import java.util.Optional;

@RestController
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final ServiceUtil serviceUtil;
    private final CategoryMapper mapper;
    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(ServiceUtil serviceUtil, CategoryRepository repository, CategoryMapper mapper) {
        this.serviceUtil = serviceUtil;
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public Category getCategory(Integer categoryId) {
        LOG.debug("/category return the found for travelPackageId={}", categoryId);

        Optional<CategoryEntity> entityCategory = repository.findById(categoryId);

        if(entityCategory.isPresent()){
            Category response = mapper.entityToApi(entityCategory.get());
            response.setServiceAddress(serviceUtil.getServiceAddress());
            response.setCategoryId(entityCategory.get().getId());
            return response;
        }

        return null;
    }

//    @Override
//    public Category createCategory(Category body) {
//        return null;
//    }
}