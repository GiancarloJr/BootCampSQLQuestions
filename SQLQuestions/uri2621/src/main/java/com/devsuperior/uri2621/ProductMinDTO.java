package com.devsuperior.uri2621;

import com.devsuperior.uri2621.projections.ProductMinProjection;

public class ProductMinDTO {

    private String name;

    public ProductMinDTO(){

    }

    public ProductMinDTO(String name) {
        this.name = name;
    }
    public ProductMinDTO(ProductMinProjection obj) {
        this.name = obj.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
