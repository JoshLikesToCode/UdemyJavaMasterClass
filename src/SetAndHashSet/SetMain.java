package SetAndHashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i = 1; i <= 100; i++)
        {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares."); //output: 100
        System.out.println("There are " + cubes.size() + " cubes."); // output: 100
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements."); // output: 196

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements."); //output: 4
        for(int i : intersection)
        {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the monkey";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for(String s : words)
        {
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1); // output: all but art thee nature unknown

        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2); // output: err forgive divine human


        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        System.out.println("\nSymmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest); // output: all but art thee err nature forgive divine human unknown

        if(nature.containsAll(divine))
        {
            System.out.println("Divine is a subset of nature"); // output: false
        }
        if(nature.containsAll(intersectionTest))
        {
            System.out.println("Intersection is a subset of nature"); // output: true
        }
        if(divine.containsAll(intersectionTest))
        {
            System.out.println("Intersection is a subset of divine."); // output: true
        }
    }


    private static void printSet(Set<String> set)
    {
        System.out.println("\t");
        for(String s : set)
        {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}
