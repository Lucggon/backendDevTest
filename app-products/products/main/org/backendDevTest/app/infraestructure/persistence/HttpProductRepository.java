package org.backendDevTest.app.infraestructure.persistence;

import org.backendDevTest.app.domain.Product;
import org.backendDevTest.app.domain.ProductRepository;
import org.backendDevTest.app.infraestructure.RequestAsyncApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;
import java.util.Set;

@Repository
public class HttpProductRepository implements ProductRepository {



    @Value("${url.store.products}")
    private String URL;
    private String PARAMS = "product/{productId}";
    private RestTemplate restTemplate;

    public HttpProductRepository(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }


    @Override
    public Set<Integer> findAllSimilarProducts(String id) {
        String URL_SIMILAR_PRODUCTS = URL + PARAMS + "/similarids";
        Set<Integer> listIdsProducts = restTemplate.getForObject(URL_SIMILAR_PRODUCTS, Set.class, id);
        return listIdsProducts;
    }

    @Override
    public Optional<Product> findOne(String id) {
        String URL_WITH_PARAM = URL + PARAMS;
        ProductEntity product = restTemplate.getForObject(URL_WITH_PARAM, ProductEntity.class, id);

        return null;
    }
}
