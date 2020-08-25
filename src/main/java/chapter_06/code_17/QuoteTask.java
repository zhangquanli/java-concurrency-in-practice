package chapter_06.code_17;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

public class QuoteTask implements Callable<TravelQuote> {
    private final TravelCompany company;
    private final TravelInfo info;

    public QuoteTask(TravelCompany company, TravelInfo info) {
        this.company = company;
        this.info = info;
    }

    TravelQuote getFailureQuote(Throwable t) {
        return null;
    }

    TravelQuote getTimeoutQuote(CancellationException e) {
        return null;
    }

    public TravelQuote call() throws Exception {
        return company.solicitQuote(info);
    }
}
