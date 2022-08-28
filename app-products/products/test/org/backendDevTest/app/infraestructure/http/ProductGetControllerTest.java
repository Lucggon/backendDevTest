package org.backendDevTest.app.infraestructure.http;
import org.backendDevTest.ApplicationTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ProductGetControllerTest extends ApplicationTestCase {
    @Test
    @DisplayName("Should request product and response should be 200")
    public void should_request_product_and_response_should_be_200() throws Exception {
        assertResponse("/product/1/similar", 200, "");
    }
    @Test
    @DisplayName("Should request product and response should be 400")
    public void should_request_product_and_response_should_be_400() throws Exception {
        assertResponse("/product/1/similar", 404, "Product Not found");
    }
}