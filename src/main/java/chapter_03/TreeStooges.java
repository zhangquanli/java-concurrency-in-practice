package chapter_03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public final class TreeStooges {
    private final Set<String> stooges = new HashSet<>();

    public TreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStorage(String name) {
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
