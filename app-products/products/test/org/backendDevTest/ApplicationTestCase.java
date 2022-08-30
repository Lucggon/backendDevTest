package org.backendDevTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ApplicationTestCase {

    @Autowired
    private MockMvc mockMvc;


    protected void assertResponse(String endpoint,
                                  Integer expectedStatusCode,
                                  MediaType mediaType
                                  ) throws Exception {

        ResultMatcher response = mediaType.equals("")
                ? content().string("") :
                content().contentType(mediaType);
        mockMvc.perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }
}
