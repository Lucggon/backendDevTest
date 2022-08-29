package org.backendDevTest.app.application.find;

import org.backendDevTest.app.domain.ProductId;
import org.backendDevTest.app.domain.Product;
import org.backendDevTest.app.domain.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductFind {

    private  final ProductRepository productRepository;

    public ProductFind(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public  ProductDTO find(String id){
        Product product = productRepository.findOne(new ProductId(id));
        ProductDTO productDTO = product.fromModelToDTO();
        return productDTO;
        }
    public Set<ProductDTO> findSimilars(String id){
        Set<ProductDTO> listProduct = new HashSet<>();
        Set<String> listIds = productRepository.findAllSimilarProducts(new ProductId(id));
        listIds.stream().forEach(
                ids -> {
                    listProduct.add(productRepository.findOne(new ProductId(ids)).fromModelToDTO());
                }
        );
        return listProduct;
    }
}
