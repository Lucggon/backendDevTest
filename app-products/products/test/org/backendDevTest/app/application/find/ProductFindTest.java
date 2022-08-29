package org.backendDevTest.app.application.find;

import org.backendDevTest.app.domain.ProductExamples;
import org.backendDevTest.app.domain.ProductId;
import org.backendDevTest.app.domain.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

class ProductFindTest {

    @Autowired
    private ProductRepository productRepositoryMock;



    @BeforeEach
    public void setUp(){
        productRepositoryMock = mock(ProductRepository.class);

    }

    @Test
    public void should_call_repository(){
        String id = "1";
        ProductFind productFind = new ProductFind(this.productRepositoryMock);
        Mockito.when(productRepositoryMock.findOne(new ProductId(id))).thenReturn(ProductExamples.create(id));
        productFind.find(id);
        Mockito.verify(productRepositoryMock, atLeastOnce()).findOne(new ProductId(id));

    }

    @Test
    public void should_return_list_similar_product_from_id(){
        String id = "1";
        String id2 = "2";
        ProductFind productFind = new ProductFind(this.productRepositoryMock);
        Mockito.when(productRepositoryMock.findAllSimilarProducts(new ProductId(id))).thenReturn(new HashSet<>(Arrays.asList("1")));
        Mockito.when(productRepositoryMock.findOne(new ProductId(id))).thenReturn(ProductExamples.create(id));
        Set<ProductDTO> listProducts =  productFind.findSimilars(id);
        Assertions.assertNotEquals(0, listProducts.size());
    }

}