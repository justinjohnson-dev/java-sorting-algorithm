import java.util.Scanner;

public class SortingAlgorithm {
    public static void main(String[] args) {
        commentOnArgs(args);

        Scanner input = new Scanner(System.in);

        pl("Enter the number of elements in the array (less than 100)");
        int size = input.nextInt();

        int[] array = new int[size];
        int[][] history = new int[size - 1][size];

        for (int i = 0; i < array.length; i++) {
            pl("Enter element number: " + i);
            array[i] = input.nextInt();
        }

        pl("List as entered is:");
        p("List is: ");
        printArray(array);
        pl("");

        boolean shouldDebug = doesArrayContain(args, "debug");

        bubbleSort(array, history, shouldDebug);

        pl("Sorting is done, here are the results from each step");
        printHistory(history);

        pl("final sort is:");
        p("List is: ");
        printArray(array);
    }

    static void swap (int[] foo, int i1, int i2) {
        int temp = foo[i1];
        foo[i1] = foo[i2];
        foo[i2] = temp;
    }

    static void bubble (int[] arr, int min, boolean shouldDebug) {
        for (int i = arr.length - 2; i >= min; i--) {
            int a = arr[i];
            int b = arr[i + 1];
            int newMin = min + 1;

            if (shouldDebug) {
                pl("\tIteration " + newMin + " swapping " + a + " with " + b);
            }

            if (Math.abs(a) > Math.abs(b)) {
                swap(arr, i, i + 1);
            }
        }
    }

    static void bubbleSort (int[] arr, int[][] history, boolean shouldDebug) {
        for (int min = 0; min < arr.length - 1; min++) {
            bubble(arr, min, shouldDebug);
            System.arraycopy(arr, 0, history[min], 0, arr.length);
        }
    }

    static void commentOnArgs(String[] args) {
        p("Arguments are: ");
        printArray(args);
        pl("other options could go here");
    }

    static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            p(arr[i] + " ");
        }
    }

    static void printArray(int[] arr) {
        p("{ ");
        for (int i = 0; i < arr.length; i++) {
            p(arr[i] + " ");
        }
        p("}");
    }

    static void printHistory(int[][] history) {
        for(int i = 0; i < history.length; i++) {
            int iterationNumber = i + 1;
            p("Listing after iteration: " + iterationNumber + " ");
            printArray(history[i]);
            pl("");
        }
    }

    static boolean doesArrayContain(String[] arr, String item) {
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                found = true;
                break;
            }
        }

        return found;
    }

    static void p(String m) {
        System.out.print(m);
    }

    static void pl(String m) {
        System.out.println(m);
    }
}
