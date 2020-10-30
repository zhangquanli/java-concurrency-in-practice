package chapter_10.code_02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 程序清单 10-2 动态的锁顺序死锁（不要这么做）
 */
public class DynamicOrderDeadlock {
    // 注意：容易发生死锁
    public static void transferMoney(Account fromAccount, Account toAccount, DollarAmount amount)
            throws InsufficientFundsException {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.getBalance().compareTo(amount) < 0) {
                    throw new InsufficientFundsException();
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }

    public static class Account {
        private DollarAmount balance;
        private final int acctNo;
        private static final AtomicInteger sequence = new AtomicInteger();

        public Account() {
            acctNo = sequence.incrementAndGet();
        }

        public void debit(DollarAmount d) {
            balance = balance.subtract(d);
        }

        public void credit(DollarAmount d) {
            balance = balance.add(d);
        }

        public DollarAmount getBalance() {
            return balance;
        }

        public int getAcctNo() {
            return acctNo;
        }
    }

    public static class DollarAmount implements Comparable<DollarAmount> {
        public DollarAmount(int amount) {
        }

        public DollarAmount add(DollarAmount d) {
            return null;
        }

        public DollarAmount subtract(DollarAmount d) {
            return null;
        }

        public int compareTo(DollarAmount o) {
            return 0;
        }
    }

    public static class InsufficientFundsException extends Exception {
    }
}
