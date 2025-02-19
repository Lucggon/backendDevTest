package org.backendDevTest.app.infraestructure.persistence;

import org.backendDevTest.app.domain.Product;
import org.backendDevTest.app.domain.ProductId;
import org.backendDevTest.app.domain.ProductNotExist;
import org.backendDevTest.app.domain.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class HttpProductRepository implements ProductRepository {

    private final Logger logger = LoggerFactory.getLogger(HttpProductRepository.class);

    @Value("${url.store.products}")
    private String URL;
    private String PARAMS = "product/{productId}";
    private RestTemplate restTemplate;
    public HttpProductRepository(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();

    }


    @Override
    public Set<String> findAllSimilarProducts(ProductId id) {
        String URL_SIMILAR_PRODUCTS = URL + PARAMS + "/similarids";
        this.logger.info("send request to " + URL_SIMILAR_PRODUCTS);
        try {
            List<String> listIdsProducts = Arrays.asList(restTemplate.getForObject(URL_SIMILAR_PRODUCTS, String[].class, id.getId()));
            return new HashSet<>(listIdsProducts);
        }catch (Exception e){
            this.logger.error("Error when try the request " + e);
            throw new ProductNotExist(id.getId());
        }
    }

    @Cacheable("product")
    @Override
    public Product findOne(ProductId id) {
        String URL_WITH_PARAM = URL + PARAMS;
        this.logger.info("send requeest to " + URL_WITH_PARAM);
        try {
            ProductEntity productEntity = restTemplate.getForObject(URL_WITH_PARAM, ProductEntity.class, id.getId());

        Product product = new Product(new ProductId(productEntity.getId()),
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getAvailability());
            return product;
        }catch (Exception p){
            this.logger.error("Error when try the request " +  p);

            throw new ProductNotExist(id.getId());
        }
    }
}
