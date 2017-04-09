package fr.ippon.microservices.documentation;

import io.github.robwin.swagger2markup.GroupBy;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

import static org.springframework.restdocs.http.HttpDocumentation.httpRequest;
import static org.springframework.restdocs.http.HttpDocumentation.httpResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * A test class that generates REST API documentation, including :
 * - Swagger basic documentation
 * - Spring restdoc documentation (REST API snippets, examples)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentationTest {
    public static final String APIDOC_SNIPPETS_OUTPUT_FOLDER = "src/docs/asciidoc/apidoc/generated-snippets";
    public static final String APIDOC_OUTPUT_FOLDER = "src/docs/asciidoc/apidoc";
    public static final String API_DOCS_URL = "/v2/api-docs";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation(APIDOC_OUTPUT_FOLDER);

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(restDocumentation).snippets()
                .withDefaults(
                        httpRequest(),
                        httpResponse())).build();
    }

    @Test
    public void convertSwaggerToAsciiDoc() throws Exception {
        this.mockMvc.perform(get(API_DOCS_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(Swagger2MarkupResultHandler
                        .outputDirectory(APIDOC_OUTPUT_FOLDER)
                        .withPathsGroupedBy(GroupBy.TAGS)
                        .withExamples(APIDOC_SNIPPETS_OUTPUT_FOLDER)
                        .build())
                .andExpect(status().isOk());
    }
}