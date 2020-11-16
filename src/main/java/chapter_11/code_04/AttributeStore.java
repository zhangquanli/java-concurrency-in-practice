package chapter_11.code_04;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 程序清单 11-4 将一个锁不必要地持有过长时间
 */
@ThreadSafe
public class AttributeStore {
    @GuardedBy("this")
    private final Map<String, String> attributes = new HashMap<>();

    public synchronized boolean userLocationMatches(String name, String regexp) {
        String key = "users." + name + ".location";
        String location = attributes.get(key);
        if (location == null) {
            return false;
        } else {
            return Pattern.matches(regexp, location);
        }
    }
}
