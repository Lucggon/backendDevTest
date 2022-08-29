package org.backendDevTest.app.domain;

import org.backendDevTest.app.application.find.ProductDTO;

import java.util.Objects;

public class Product {
    private ProductId id;
    private String name;
    private Double price;
    private Boolean availability;

    public Product(ProductId id, String name, Double price, Boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public ProductId getId(){
        return this.id;
    }

    public ProductDTO fromModelToDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.id.getId());
        productDTO.setName(this.name);
        productDTO.setAvailibility(this.availability);
        productDTO.setPrice(this.price);
        return productDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(availability, product.availability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, availability);
    }
}
