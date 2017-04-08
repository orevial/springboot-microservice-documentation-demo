package fr.ippon.microservices.model;

import java.util.List;

/**
 * Représente le corps de la requête de recherche
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
