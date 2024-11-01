import java.util.Random;
import java.util.Scanner;

import java.util.Arrays;

class random_array_generator {
    public static Random rand = new Random();

    // Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
    public static Integer[] createRandomArray(Integer[] arrayInts) {
        for (int i = 0; i < arrayInts.length; i++) {
            arrayInts[i] = rand.nextInt();
        }

        return arrayInts;
    }

    // Given arrayLength as argument, create an array of random doubles; return the created array.
    public static Double[] createRandomArray(Double[] arrayDoubles) {
        for (int i = 0; i < arrayDoubles.length; i++) {
            arrayDoubles[i] = rand.nextDouble();
        }

        return arrayDoubles;
    }

    // Given arrayLength as argument, create an array of random floats; return the created array.
    public static Float[] createRandomArray(Float[] arrayFloats) {
        for (int i = 0; i < arrayFloats.length; i++) {
            arrayFloats[i] = rand.nextFloat();
        }

        return arrayFloats;
    }

    // Given arrayLength as argument, create an array of random longs; return the created array.
    public static Long[] createRandomArray(Long[] arrayLongs) {
        for (int i = 0; i < arrayLongs.length; i++) {
            arrayLongs[i] = rand.nextLong();
        }

        return arrayLongs;
    }
}

public class generic_sort_compare {
    public static Scanner scan = new Scanner(System.in);

    static <T extends Comparable<T>> void merge_sort(T[] arr, int first, int last) {
        if (first < last) {
            int middle = first + (last - first) / 2;

            merge_sort(arr, first, middle);
            merge_sort(arr, middle + 1, last);

            merge(arr, first, middle, last);
        }
    }

    static <T extends Comparable<T>> void merge(T[] arr, int first, int middle, int last) {
        int len1 = middle - first + 1;
        int len2 = last - middle;
        
        T[] arrL = (T[]) new Comparable[len1];
        T[] arrR = (T[]) new Comparable[len2];

        for (int i = 0; i < len1; ++i) {
            arrL[i] = arr[first + i];
        }
        for (int j = 0; j < len2; ++j) {
            arrR[j] = arr[middle + 1 + j];
        }

        int tracker1 = 0, tracker2 = 0;

        int k = first;
        while (tracker1 < len1 && tracker2 < len2) {
            if (arrL[tracker1].compareTo(arrR[tracker2]) <= 0) {
                arr[k] = arrL[tracker1++];
            } else {
                arr[k] = arrR[tracker2++];
            }

            k++;
        }

        while (tracker1 < len1) {
            arr[k] = arrL[tracker1++];
            k++;
        }

        while (tracker2 < len2) {
            arr[k] = arrR[tracker2++];
            k++;
        }
    }

    public static <T extends Comparable<T>> void bubble_sort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean changed = false;
            for (int j = 0; j < arr.length - 1; j++) {
                T tempVar = arr[j];
                if (tempVar.compareTo(arr[j + 1]) > 0) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempVar;
                    changed = true;
                }
            }

            if (changed == false) {
                break;
            }
        }
    }

    public static <T extends Comparable<T>> void main(String[] args) {
        System.out.println("----------------------------------------");
        System.out.println("--                                    --");
        System.out.println("--        GENERIC SORT COMPARE        --");
        System.out.println("--     not like the other sorters     --");
        System.out.println("--                                    --");
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("Welcome to the GENERIC SORT COMPARER!");
        System.out.println("This program will ask you for a data type (t) and a number (n) and will then generate an array of type t with n elements.");
        System.out.println("It will then sort the array using both Bubble sort and Merge sort, and then display a time comparison for both sorts in nanoseconds.");
        System.out.println();

        while (true) {
            System.out.print("Enter anything to continue...");
            scan.nextLine();
            System.out.println();

            System.out.println("What kind of data type would you like to sort?");
            System.out.println("Options: int, long, double, float");
            System.out.println();
            System.out.println("Or enter 'bravo' to exit.");
            System.out.print("Choice: ");
            String usrInput = scan.nextLine().toLowerCase();

            T[] arr1 = (T[]) new Comparable[0];
            T[] arr2 = (T[]) new Comparable[0];
            
            int numOfValues;

            if (usrInput.equals("bravo") || usrInput.equals("b")) {
                scan.close();
                System.out.println();
                System.out.println("Thank you for using the generic sort comparer!");
                break;
            } else if (usrInput.equals("int") ||usrInput.equals("i")) {
                System.out.print("How many integers do you want generated: ");
                usrInput = scan.nextLine();
                args = usrInput.split(" ");

                try {
                    numOfValues = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Invalid input!");
                    System.out.println();
                    continue;
                }
                System.out.println();

                arr1 = (T[]) random_array_generator.createRandomArray(new Integer[numOfValues]);
            } else if (usrInput.equals("long") ||usrInput.equals("l")) {
                System.out.print("How many longs do you want generated: ");
                usrInput = scan.nextLine();
                args = usrInput.split(" ");

                try {
                    numOfValues = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Invalid input!");
                    System.out.println();
                    continue;
                }
                System.out.println();

                arr1 = (T[]) random_array_generator.createRandomArray(new Long[numOfValues]);
            } else if (usrInput.equals("double") ||usrInput.equals("d")) {
                System.out.print("How many doubles do you want generated: ");
                usrInput = scan.nextLine();
                args = usrInput.split(" ");

                try {
                    numOfValues = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Invalid input!");
                    System.out.println();
                    continue;
                }
                System.out.println();

                arr1 = (T[]) random_array_generator.createRandomArray(new Double[numOfValues]);
            } else if (usrInput.equals("float") ||usrInput.equals("f")) {
                System.out.print("How many floats do you want generated: ");
                usrInput = scan.nextLine();
                args = usrInput.split(" ");

                try {
                    numOfValues = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Invalid input!");
                    System.out.println();
                    continue;
                }
                System.out.println();

                arr1 = (T[]) random_array_generator.createRandomArray(new Float[numOfValues]);
            } else {
                System.out.println();
                System.out.println("Invalid input!");
                System.out.println();
                continue;
            }

            arr2 = arr1.clone();
            
            System.out.println("Initial array: " + Arrays.toString(arr1));
            System.out.println();

            long startMerge = System.nanoTime();
            merge_sort(arr1, 0, arr1.length - 1);
            long endMerge = System.nanoTime();

            System.out.println("Sorted array: " + Arrays.toString(arr1));
            System.out.println();

            System.out.println("Bubble Sort:");
            long startBubble = System.nanoTime();
            bubble_sort(arr2);
            long endBubble = System.nanoTime();

            System.out.println("Elapsed Time in nano seconds: "+ (endBubble - startBubble));
            System.out.println();

            System.out.println("Merge Sort:");
            System.out.println("Elapsed Time in nano seconds: "+ (endMerge - startMerge));
            System.out.println(); 
        }
    }
}
