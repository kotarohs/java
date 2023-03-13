import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class A3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = 0;
        try {
            size = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Size should be an integer.");
            return;
        }
        int[] array = new int[size];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            try {
                String input = scanner.next();
                array[i] = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Element at index " + i + " should be an integer.");
                i--;
            }
        }
        scanner.close();
        int sum = condition1(array);
        String pin = condition2(array);
        System.out.println("Single digit sum: " + sum);
        System.out.println("PIN: " + pin);
    }

    public static int condition1(int[] array) {
        int sum = Arrays.stream(array).sum();
        while (sum > 9) {
            sum = getSumOfDigits(sum);
        }
        return sum;
    }

    public static int getSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static String condition2(int[] array) {
        StringBuilder pin = new StringBuilder();
        for (int num : array) {
            if (num % 2 != 0) {
                char alphabet = (char) ((num - 1) / 2 + 'a');
                pin.append(alphabet);
            } else {
                pin.append(num);
            }
        }
        return pin.toString();
    }
}
