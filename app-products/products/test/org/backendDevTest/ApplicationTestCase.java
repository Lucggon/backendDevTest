package org.backendDevTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTestCase {

    @Autowired
    private MockMvc mockMvc;

    protected void assertResponse(String endpoint,
                                  Integer expectedStatusCode,
                                  String expectedResponse,
                                  HttpHeaders header) throws Exception {

        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("") :
                content().string(expectedResponse);
        mockMvc.perform(get(endpoint).headers(header))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }
    protected void assertResponse(String endpoint,
                                  Integer expectedStatusCode,
                                  String expectedResponse
                                  ) throws Exception {

        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("") :
                content().string(expectedResponse);
        mockMvc.perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }
}
