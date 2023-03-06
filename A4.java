import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please choose between imperial and metric (i/m): ");
        String choice = scanner.nextLine().toLowerCase();

        double weight, height;

        if (choice.equals("m")) {
            System.out.print("Please enter your weight in kilograms: ");
            weight = scanner.nextDouble();
            System.out.print("Please enter your height in centimeters: ");
            height = scanner.nextDouble() / 100;
        } else {
            System.out.print("Please enter your weight in pounds: ");
            weight = scanner.nextDouble();
            System.out.print("Please enter your height in inches: ");
            height = scanner.nextDouble();
        }

        double bmi = (weight * 711) / Math.pow(height, 2);

        System.out.printf("Your BMI is %.2f\n", bmi);
    }
}
