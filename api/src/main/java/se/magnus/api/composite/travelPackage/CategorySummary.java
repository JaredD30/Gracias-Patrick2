package se.magnus.api.composite.travelPackage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class CategorySummary {
    private Integer categoryId;
    private String name;

    public CategorySummary(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
