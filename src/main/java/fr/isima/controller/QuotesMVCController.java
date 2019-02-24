package fr.isima.controller;

import fr.isima.business.QuotesService;
import fr.isima.data.QuoteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quotes")
public class QuotesMVCController {

    private final QuotesService quotesService;

    @Autowired
    public QuotesMVCController(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping("{quoteNumber}")
    public ModelAndView displayQuote(@PathVariable(required = false) Integer quoteNumber) {
        return getQuote("quote", quoteNumber);
    }

    @PostMapping(consumes = {"*"})
    public String displayQuote( QuoteBean quoteBean) {
        quotesService.save(quoteBean);
        return "redirect:/main";
    }


    ModelAndView getQuote(String viewName, Integer quoteNumber) {
        return new ModelAndView(viewName, "quote", quotesService.findById(quoteNumber));
    }

}
