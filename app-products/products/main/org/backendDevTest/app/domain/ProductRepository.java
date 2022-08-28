package org.backendDevTest.app.domain;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepository {

    Set<Integer> findAllSimilarProducts(String id);
    Optional<Product> findOne(String id);
}
