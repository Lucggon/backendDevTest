package org.backendDevTest.app.domain;

import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private Double price;
    private Boolean required;

    public Product(String id, String name, Double price, Boolean required) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.required = required;
    }

    public String getId(){
        return this.id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(required, product.required);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, required);
    }
}
