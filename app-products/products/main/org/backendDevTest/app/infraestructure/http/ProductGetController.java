package org.backendDevTest.app.infraestructure.http;

import org.backendDevTest.app.application.find.ProductDTO;
import org.backendDevTest.app.application.find.ProductFind;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ProductGetController {
    private final ProductFind productFind;

    public ProductGetController(ProductFind productFind){
        this.productFind = productFind;
    }

    @GetMapping("/product/{productId}/similar")
    public ResponseEntity similarProducts(@PathVariable String productId){
        Set<ProductDTO> productDTO = productFind.findSimilars(productId);
        return ResponseEntity.ok().body(
                productDTO
        );
    }

}
