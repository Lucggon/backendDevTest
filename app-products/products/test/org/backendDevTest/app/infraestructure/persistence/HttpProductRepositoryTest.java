package org.backendDevTest.app.infraestructure.persistence;


import org.backendDevTest.app.domain.ProductId;
import org.backendDevTest.app.domain.ProductNotExist;
import org.backendDevTest.app.domain.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



class HttpProductRepositoryTest extends ProductInfraestructureTestCase {


    @Autowired
    ProductRepository productRepository;

    @Test
    public void should_find_one_product() {
        String productId = "1";

       Assertions.assertEquals(productId, productRepository.findOne(new ProductId(productId)).getId().getId());
    }

    @Test
    public void should_not_find_product_and_throw_productNotExist() {
        String productId = "random";
        Assertions.assertThrows(ProductNotExist.class, () -> {productRepository.findOne(new ProductId(productId));});
    }
    @Test
    public void should_find_similar_objects_and_return_list() {
        String productId = "1";

        Assertions.assertNotEquals(0, productRepository.findAllSimilarProducts(new ProductId(productId)).size());
    }
}