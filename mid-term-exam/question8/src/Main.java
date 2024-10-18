import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void sortDescending(List<Integer> numbers) {
        // sort the list in descending order using a lambda expression
        numbers.sort((a, b) -> b - a);
    }

    public static void main(String[] args) {
        System.out.println("Sorting...");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);

        sortDescending(numbers);
        System.out.println(numbers);
    }
}