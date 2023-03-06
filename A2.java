import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of test cases: ");
        int numTestCases = input.nextInt();

        input.nextLine(); // consume the remaining newline character

        for (int i = 0; i < numTestCases; i++) {
            System.out.println("Enter password for test case " + (i + 1) + ":");
            String password = input.nextLine();

            boolean condition1 = false;
            boolean condition2 = false;
            boolean condition3 = false;
            boolean condition4 = false;
            boolean condition5 = false;

            if (password.length() >= 10) {
                condition5 = true;
                for (char ch : password.toCharArray()) {
                    if (Character.isLowerCase(ch)) {
                        condition1 = true;
                    } else if (Character.isUpperCase(ch)) {
                        condition2 = true;
                    } else if (Character.isDigit(ch)) {
                        condition3 = true;
                    } else if (ch == '@' || ch == '#' || ch == '%' || ch == '&' || ch == '?') {
                        condition4 = true;
                    }
                }
            }

            if (condition1 && condition2 && condition3 && condition4 && condition5) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
