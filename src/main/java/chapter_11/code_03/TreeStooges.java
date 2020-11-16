package chapter_11.code_03;

import net.jcip.annotations.Immutable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * 程序清单 11-3 可通过锁消除优化去掉的锁获取操作
 */
@Immutable
public final class TreeStooges {
    private final Set<String> stooges = new HashSet<>();

    public TreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooges(String name) {
        return stooges.contains(name);
    }

    public String getStoogeNames() {
        List<String> stooges = new Vector<>();
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
        return stooges.toString();
    }
}
