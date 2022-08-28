package org.backendDevTest.app.infraestructure.http;

import org.backendDevTest.app.application.find.ProductFind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductGetController {
    private final ProductFind productFind;

    public ProductGetController(ProductFind productFind){
        this.productFind = productFind;
    }

    @GetMapping("/product/{productId}/similar")
    public ResponseEntity similarProducts(@PathVariable String productId){

        return new ResponseEntity("Product Not found", HttpStatus.NOT_FOUND);
    }


}
