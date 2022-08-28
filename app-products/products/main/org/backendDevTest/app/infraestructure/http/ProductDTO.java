package org.backendDevTest.app.infraestructure.http;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private  String id;
    private  String name;
    private  Double price;
    private  Boolean availibility;


}
