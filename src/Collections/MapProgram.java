package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if(languages.containsKey("Java"))
            System.out.println("Java is already in the map.");
        else
            languages.put("Java", "a compiled high level, object-oriented, platform independent language.");

        languages.put("Python", "an interpreted, object-oriented, high-level programming language");
        languages.put("Algol", "an algorithmic language");
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        languages.put("Lisp", "Therein lies all madness");

        if(languages.containsKey("Java"))
            System.out.println("Java is already in the map.");
        else
            languages.put("Java", "Only add an item once w/o being over-ridden.");
        System.out.println(languages.get("Java"));

        System.out.println("==================================================================");

        // languages.remove("Lisp");
        if(languages.remove("Algol", "an algorithmic language"))
            System.out.println("Algol removed");
        else
            System.out.println("Algol not removed, key/value pair not found.");

        if(languages.replace("Lisp", "Therein lies all madness", "a functional programming language"))
            System.out.println("Lisp replaced!");
        else
            System.out.println("Lisp was not replaced");


        for(String key : languages.keySet())
            System.out.println("key = " + key + ", value = " + languages.get(key));
    }
}
