package com.felipeleres.flcommerce.dto;


import com.felipeleres.flcommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public class ProductMinDTO {

    private Long id;
    private String name;
    private Double price;
    private String imgUrl;


    public ProductMinDTO() {

    }

    public ProductMinDTO(Long id, String name, String imgUrl, Double price) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public ProductMinDTO(Product product){
        id = product.getId();
        name = product.getName();
        imgUrl = product.getImgUrl();
        price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
