package fr.isima.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SelectedQuoteTest {

    private List<Quote> quotesList;
    private Quotes quotes;
    private Quote quote1;
    private Quote quote2;

    private SelectedQuote selectedQuote1;

    @BeforeEach
    public void initQuotes() {
        quote1 = new Quote("William Shakespeare", "All that glitters is not gold", 0);
        quote2 = new Quote("William Shakespeare", "A rose by any other name would smell as sweet.", 1);
        this.quotesList = Arrays.asList(quote1, quote2);
        this.quotes = new Quotes(quotesList);
        selectedQuote1 = new SelectedQuote(this.quotes, this.quote1);
    }

    @Test
    public void selectedQuote1_nextQuote_shouldBeNextQuoteRange() {
        assertThat(selectedQuote1.nextQuote()).isEqualTo(1);
    }
}