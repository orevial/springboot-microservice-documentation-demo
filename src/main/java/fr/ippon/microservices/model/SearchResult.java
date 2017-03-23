package fr.ippon.microservices.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivier.revial on 23/03/2017.
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
