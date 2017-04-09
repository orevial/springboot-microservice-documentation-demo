package fr.ippon.microservices.documentation;

import fr.ippon.microservices.web.SampleControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.ippon.microservices.web.SampleController;

/**
 * Test suite to make sure Swagger documentation is generated by the
 * integration test after and only after all documentation snippets tests
 * have run. DocumentationIT should always run after all the other tests
 * generating doc examples !
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DocumentationTest.class,
        SampleControllerTest.class})
public class DocumentationTestSuiteIT {

}