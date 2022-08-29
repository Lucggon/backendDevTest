package org.backendDevTest.app.domain;

import org.backendDevTest.app.domain.Product;
import org.backendDevTest.app.domain.ProductId;

public class ProductExamples {

    public static Product create(String id){
        return new Product(new ProductId(id),
                "name", 12.2, true);
    }

}