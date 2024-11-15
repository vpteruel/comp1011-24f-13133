import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println();

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Reflection", "Collection", "Stream"),
                Arrays.asList("Structure", "State", "Flow"),
                Arrays.asList("Sorting", "Searching", "Stream", "Mapping"));

        Set<String> intermediateResults = new HashSet<>();

        List<String> results = listOfLists
                .stream()
                .flatMap(List::stream)
                .filter(p -> p.startsWith("S"))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .peek(p -> intermediateResults.add(p))
                .collect(Collectors.toUnmodifiableList());

        System.out.println("Intermediate Results:");
        intermediateResults.forEach(System.out::println);

        System.out.println();
        System.out.println("Final Results:");
        results.forEach(System.out::println);

        System.out.println();
        System.out.println("##########################################");

        List<String> fruits = Arrays.asList("Apple", "Pear", "Bananas", "Pineapple", "Mango");

        System.out.println();
        System.out.println("fruits:");
        fruits.forEach(System.out::println);

        List<String> filteredFruits = fruits
                .stream()
                .filter(fruit -> fruit.startsWith("P"))
                .toList();

        System.out.println();
        System.out.println("filtered fruits:");
        filteredFruits.forEach(System.out::println);

        String concatenatedFruits = fruits
                .stream()
                .reduce("", (partialString, element) -> partialString + " " + element);

        System.out.println();
        System.out.println("concatenated fruits: " + concatenatedFruits);

        long count = fruits.stream().count();

        System.out.println();
        System.out.println("count of fruits: " + count);

        Optional<String> firstFruit = fruits.stream().findFirst();

        System.out.println();
        System.out.println("first fruit: " + firstFruit);

        boolean allStartsWithP = fruits.stream().allMatch(fruit-> fruit.startsWith("P"));

        System.out.println();
        System.out.println("all starts with P: " + allStartsWithP);

        boolean anyStartsWithB = fruits.stream().anyMatch(fruit-> fruit.startsWith("B"));

        System.out.println();
        System.out.println("any starts with B: " + anyStartsWithB);

    }
}