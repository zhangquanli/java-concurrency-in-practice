package chapter_06.code_17;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Requesting travel quotes under a time budget.
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
