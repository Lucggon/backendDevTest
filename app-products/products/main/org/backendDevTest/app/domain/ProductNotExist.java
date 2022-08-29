package org.backendDevTest.app.domain;

import org.backendDevTest.shared.domain.DomainError;

public class ProductNotExist extends DomainError {
    public ProductNotExist(String id){
        super("Product not found", String.format("product with id %s not found", id));
    }
}
