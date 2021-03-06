package fr.ippon.microservices.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente la réponse à la requête de recherche.
 */
public class SearchResult {
    private List<String> phrases = new ArrayList<>();

    public List<String> getPhrases() {
        return phrases;
    }

    public void addPhrase(String phrase) {
        this.phrases.add(phrase);
    }
}
