import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

public class SynchronizedFactorizer extends GenericServlet implements Servlet {
    private BigInteger lastNumber;
    private BigInteger[] lastFactors;

    @Override
    public synchronized void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber)) {
            encodeIntoResponse(resp, lastFactors);
        } else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(resp, lastFactors);
        }
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{i};
    }
}
