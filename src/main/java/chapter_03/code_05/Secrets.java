package chapter_03.code_05;

import java.util.HashSet;
import java.util.Set;

/**
 * 程序清单 3-5 发布一个对象
 */
public class Secrets {
    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<>();
    }

    public static class Secret {
    }
}
