package chapter_11.code_06;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * 程序清单 11-6 对锁进行分解
 */
@ThreadSafe
public class ServerStatusBeforeSplit {
    @GuardedBy("this")
    public final Set<String> users;
    @GuardedBy("this")
    public final Set<String> queries;

    public ServerStatusBeforeSplit() {
        users = new HashSet<>();
        queries = new HashSet<>();
    }

    public synchronized void addUser(String user) {
        users.add(user);
    }

    public synchronized void addQuery(String query) {
        queries.add(query);
    }

    public synchronized void removeUser(String user) {
        users.remove(user);
    }

    public synchronized void removeQuery(String query) {
        queries.remove(query);
    }
}
