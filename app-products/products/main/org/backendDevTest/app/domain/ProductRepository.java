package org.backendDevTest.app.domain;

import java.util.Set;

public interface ProductRepository {

    Set<String> findAllSimilarProducts(ProductId id);
    Product findOne(ProductId id);
}
