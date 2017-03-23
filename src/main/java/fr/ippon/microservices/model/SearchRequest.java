package fr.ippon.microservices.model;

import java.util.List;

/**
 * Created by olivier.revial on 23/03/2017.
 */
public class SearchRequest {
    private List<String> keywords;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
