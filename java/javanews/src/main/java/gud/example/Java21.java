package gud.example;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;

public class Java21 {
    //String literals (preview)
    public static void main(String[] args) {
        String newString = "Apple";
        String literalString = newString."Cherry";

        //Sequenced collection interfaces and implementations
        SequencedCollection<String> sequencedCollection = new LinkedHashSet<>();
        SequencedMap<String, String> sequencedMap = new LinkedHashMap<>();
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();

        //Virtual threads stil in preview
    }

}
