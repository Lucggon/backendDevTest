package org.backendDevTest.app.domain;

import java.util.Objects;

public class ProductId {
    private String id;

    public ProductId(String id){
        ensureIdIsPresent(id);
        this.id = id;


    }
    public String getId(){
        return this.id;
    }
    private void ensureIdIsPresent(String id){
        try{
            Integer.valueOf(id);
        }catch (Exception e){
            throw  new ProductNotExist(id);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
