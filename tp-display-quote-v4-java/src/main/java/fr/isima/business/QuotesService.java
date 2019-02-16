package fr.isima.business;

import fr.isima.data.QuoteBean;
import fr.isima.data.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class QuotesService {

    private final QuotesRepository quotesRepository;

    @Autowired
    public QuotesService(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    public Quotes findAll() {
        return new Quotes(StreamSupport.stream(this.quotesRepository.findAll().spliterator(), false)
                .map(Quote::new).collect(Collectors.toList()));
    }

    public SelectedQuote findById(Integer quoteId) {
        if (quotesRepository.existsById(quoteId)) {
            return new SelectedQuote(findAll(), new Quote(this.quotesRepository.findById(quoteId).get()));
        }
        return createDefaultQuote(quoteId);
    }

    private SelectedQuote createDefaultQuote(Integer numero) {
        final QuoteBean qb = new QuoteBean();
        qb.setAuthor("L'auteur de l'application");
        qb.setContent("Aucune citation n'existe au numero " + numero);
        return new SelectedQuote(findAll(), new Quote(qb));
    }


    public Integer save(QuoteBean quoteBean) {
        return this.quotesRepository.save(quoteBean).getId();
    }
}
