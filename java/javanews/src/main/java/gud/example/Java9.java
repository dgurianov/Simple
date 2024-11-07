package gud.example;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Java9 {
    public static void main(String[] args) {
        //SetOf , MapOf etc...
        //Before
        Set<String> setBefore = new HashSet<>();
        setBefore.add("Appple");
        setBefore.add("Cherry");
        setBefore.add("Vodka");
        setBefore = Collections.unmodifiableSet(setBefore);

        //After
        Set<String> setAfter = Set.of("Apple","Cherry","Vodka");
    }
}

