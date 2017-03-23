package fr.ippon.microservices.web;

import fr.ippon.microservices.model.SearchRequest;
import fr.ippon.microservices.model.SearchResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample controllers with example methods
 */
@RestController
@RequestMapping("/api/sample-controller")
public class SampleController {

    /**
     * Return a sample String parameter
     * @return one of the custom string settings
     */
    @RequestMapping(method = RequestMethod.GET, value = "/method1")
    public String method1() {
        return "This is method 1 return value";
    }

    /**
     * Return a sample boolean parameter
     * @return one of the custom boolean settings
     */
    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public SearchResult search(@RequestBody SearchRequest searchRequest) {
        SearchResult searchResult = new SearchResult();
        searchRequest.getKeywords().forEach(
                keyword -> searchResult.addPhrase("Phrase with keyword " + keyword)
        );
        return searchResult;
    }
}