package fr.ippon.microservices.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ippon.microservices.model.SearchRequest;
import fr.ippon.microservices.model.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for SampleController.
 * This class will basically test that all methods defined in SampleController behave as expected.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMethod1() throws Exception {
        mockMvc.perform(get("/api/sample-controller/method1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("This is method 1 return value"));
    }

    @Test
    public void testSearch() throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setKeywords(Arrays.asList("Test keyword 1", "Test keyword 2", "Test keyword 3"));

        SearchResult expectedSearchResult = new SearchResult();
        expectedSearchResult.addPhrase("Phrase with keyword Test keyword 1");
        expectedSearchResult.addPhrase("Phrase with keyword Test keyword 2");
        expectedSearchResult.addPhrase("Phrase with keyword Test keyword 3");

        this.mockMvc.perform(post("/api/sample-controller/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchRequest)))
                .andExpect(content().string(objectMapper.writeValueAsString(expectedSearchResult)));
    }
}