package chapter_11.code_07;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * 程序清单 11-7 将 ServerStatus 重新改写为使用锁分解技术
 */
@ThreadSafe
public class ServerStatusAfterSplit {
    @GuardedBy("users")
    public final Set<String> users;
    @GuardedBy("queries")
    public final Set<String> queries;

    public ServerStatusAfterSplit() {
        users = new HashSet<>();
        queries = new HashSet<>();
    }

    public void addUser(String user) {
        synchronized (users) {
            users.add(user);
        }
    }

    public void addQuery(String query) {
        synchronized (queries) {
            queries.add(query);
        }
    }

    public void removeUser(String user) {
        synchronized (users) {
            users.add(user);
        }
    }

    public void removeQuery(String query) {
        synchronized (queries) {
            queries.add(query);
        }
    }
}
