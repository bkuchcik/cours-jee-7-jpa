package fr.isima.business;

import fr.isima.data.QuoteBean;

/**
 * L'objet immuable contenant les citations
 *
 * @author Benjamin Kuchcik
 * @see Quotes
 */
public class Quote {


    /**
     * Le champ est final, il doit donc �tre initialis� dans le constructeur.
     */
    private final QuoteBean quoteBean;

    public Quote(QuoteBean quoteBean) {
        this.quoteBean = quoteBean;
    }

    public String getAuthor() {
        return quoteBean.getAuthor();
    }

    public String getContent() {
        return quoteBean.getContent();
    }

    public Integer getId() {return quoteBean.getId();}
}
