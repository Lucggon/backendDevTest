package org.backendDevTest.app.infraestructure.persistence;

import org.backendDevTest.Starter;
import org.backendDevTest.app.infraestructure.InfraestructureTestCase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Starter.class)
@ActiveProfiles("test")
public class ProductInfraestructureTestCase extends InfraestructureTestCase {
}
