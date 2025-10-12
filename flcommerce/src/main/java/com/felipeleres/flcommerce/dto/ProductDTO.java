package com.felipeleres.flcommerce.dto;


import com.felipeleres.flcommerce.entities.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductDTO () {

    }

    public ProductDTO(Long id, String name, String description, String imgUrl, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public ProductDTO (Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        imgUrl = product.getImgUrl();
        price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
