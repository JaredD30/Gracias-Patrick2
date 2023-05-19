package se.magnus.api.core.category;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Integer categoryId;
    private String name;
    private String serviceAddress;
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

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

}
