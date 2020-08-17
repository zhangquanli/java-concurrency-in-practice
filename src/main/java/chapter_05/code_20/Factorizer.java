package chapter_05.code_20;

import chapter_05.code_16.Computable;
import chapter_05.code_19.Memoizer;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * Factorizing servlet that caches results using Memoizer.
 */
@ThreadSafe
public class Factorizer extends GenericServlet implements Servlet {
    private final Computable<BigInteger, BigInteger[]> c = this::factor;
    private final Computable<BigInteger, BigInteger[]> cache = new Memoizer<>(c);

    public void service(ServletRequest req, ServletResponse resp) {
        try {
            BigInteger i = extractFromRequest(req);
            encodeIntoResponse(resp, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(resp, "factorization interrupted");
        }
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    private BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    private void encodeError(ServletResponse resp, String errorString) {
    }
}