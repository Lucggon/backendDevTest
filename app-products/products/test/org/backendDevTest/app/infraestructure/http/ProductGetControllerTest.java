package org.backendDevTest.app.infraestructure.http;
import org.backendDevTest.ApplicationTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class ProductGetControllerTest extends ApplicationTestCase {
    @Test
    @DisplayName("Should request product and response should be 200")
    public void should_request_product_and_response_should_be_200() throws Exception {
        assertResponse("/product/1/similar", 200, MediaType.APPLICATION_JSON);
    }
    @Test
    @DisplayName("Should request product and response should be 404")
    public void should_request_product_and_response_should_be_404() throws Exception {
        assertResponse("/product/random/similar", 404, MediaType.APPLICATION_JSON);
    }
}