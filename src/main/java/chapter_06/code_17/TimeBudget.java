package chapter_06.code_17;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 程序清单 6-17 在预定时间内请求旅游报价
 */
public class TimeBudget {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public List<TravelQuote> getRankedTravelQuotes(
            TravelInfo info, Set<TravelCompany> companies,
            Comparator<TravelQuote> ranking, long time, TimeUnit timeUnit
    ) throws InterruptedException {
        List<QuoteTask> tasks = companies.stream()
                .map(company -> new QuoteTask(company, info))
                .collect(Collectors.toList());
        List<Future<TravelQuote>> futures = exec.invokeAll(tasks, time, timeUnit);
        Iterator<QuoteTask> taskIter = tasks.iterator();
        List<TravelQuote> quotes = new ArrayList<>(tasks.size());
        for (Future<TravelQuote> f : futures) {
            QuoteTask task = taskIter.next();
            try {
                quotes.add(f.get());
            } catch (ExecutionException e) {
                quotes.add(task.getFailureQuote(e.getCause()));
            } catch (CancellationException e) {
                quotes.add(task.getTimeoutQuote(e));
            }
        }
        quotes.sort(ranking);
        return quotes;
    }
}

class QuoteTask implements Callable<TravelQuote> {
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

interface TravelCompany {
    TravelQuote solicitQuote(TravelInfo travelInfo) throws Exception;
}

interface TravelInfo {
}

interface TravelQuote {
}
