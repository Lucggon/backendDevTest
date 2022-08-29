package org.backendDevTest.app.application.find;


import java.util.Objects;


public class ProductDTO {
    private  String id;
    private  String name;
    private  Double price;
    private  Boolean availibility;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailibility() {
        return availibility;
    }

    public void setAvailibility(Boolean availibility) {
        this.availibility = availibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(availibility, that.availibility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, availibility);
    }
}
