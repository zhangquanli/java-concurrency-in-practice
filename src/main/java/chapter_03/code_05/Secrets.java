package chapter_03.code_05;

import java.util.HashSet;
import java.util.Set;

/**
 * Publishing an object.
 */
public class Secrets {
    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<>();
    }

    static class Secret {
    }
}
