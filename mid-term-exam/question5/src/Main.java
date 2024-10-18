public class Main {
    public static void main(String[] args) {
        System.out.println("Finding the maximum element");

        int[] numbers = {45, 23, 78, 12, 89, 34};

        int maxElement = findMax(numbers);

        System.out.println("The maximum element is: " + maxElement);
    }

    public static int findMax(int[] array) {
        // assume the first element is the maximum
        int max = array[0];

        // loop through the array to find the maximum
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // update max if current element is greater
            }
        }
        return max;
    }
}