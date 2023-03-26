package fr.isima.business;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quotes {

    private final List<Quote> quotes;

    public Quotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<Quote> getQuotes() {
        return Collections.unmodifiableList(quotes);
    }

    public int size() {
        return quotes.size();
    }

    public static Quotes empty() {
        return new Quotes(Arrays.asList());
    }

}
